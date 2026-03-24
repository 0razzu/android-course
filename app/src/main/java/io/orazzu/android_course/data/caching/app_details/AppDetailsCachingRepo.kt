package io.orazzu.android_course.data.caching.app_details

import android.util.Log
import io.orazzu.android_course.data.edu_catalog.EduCatalogApi
import io.orazzu.android_course.data.edu_catalog.app_details.AppDetailsEduCatalogMapper
import io.orazzu.android_course.domain.DomainError
import io.orazzu.android_course.domain.DomainResult
import io.orazzu.android_course.domain.app_details.AppDetails
import io.orazzu.android_course.domain.app_details.AppDetailsRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import java.net.HttpURLConnection.HTTP_NOT_FOUND
import javax.inject.Inject

class AppDetailsCachingRepo @Inject constructor(
    private val dao: AppDetailsDao,
    private val appDetailsLocalMapper: AppDetailsEntityMapper,
    private val remoteApi: EduCatalogApi,
    private val appDetailsRemoteMapper: AppDetailsEduCatalogMapper,
) : AppDetailsRepo {
    private val logTag = this.javaClass.simpleName

    override suspend fun getAppDetails(id: String): DomainResult<AppDetails> {
        Log.d(logTag, "Getting app $id")

        return try {
            when (val cached = withContext(Dispatchers.IO) { dao.getAppDetails(id) }) {
                is AppDetailsEntity -> {
                    CoroutineScope(Dispatchers.IO).launch {
                        val fresh = getAppDetailsFromRemote(id)
                        if (fresh is DomainResult.Success) {
                            putAppDetails(fresh.data)
                        }
                    }

                    DomainResult.Success(appDetailsLocalMapper.toDomain(cached))
                }

                null -> when (val fresh = getAppDetailsFromRemote(id)) {
                    is DomainResult.Success -> {
                        withContext(Dispatchers.IO) {
                            putAppDetails(fresh.data)
                        }
                        fresh
                    }

                    is DomainResult.Failure -> fresh
                }
            }
        } catch (e: IOException) {
            Log.e(logTag, "DB IO exception while getting app $id", e)

            DomainResult.Failure(DomainError.UNKNOWN)
        } catch (e: Exception) {
            Log.e(logTag, "Unexpected exception while getting app $id", e)

            DomainResult.Failure(DomainError.UNKNOWN)
        }
    }

    private suspend fun getAppDetailsFromRemote(id: String): DomainResult<AppDetails> {
        Log.d(logTag, "Getting app $id from remote")

        return try {
            val appDetailsDto = remoteApi.getAppById(id)
            DomainResult.Success(appDetailsRemoteMapper.toDomain(appDetailsDto))
        } catch (e: HttpException) {
            if (e.code() == HTTP_NOT_FOUND) {
                Log.w(logTag, "App $id not found in remote", e)

                DomainResult.Failure(DomainError.NOT_FOUND)
            } else {
                throw e
            }
        } catch (e: IOException) {
            Log.e(logTag, "Connection error while getting app $id from remote", e)

            DomainResult.Failure(DomainError.CONNECTION_ERROR)
        } catch (e: Exception) {
            Log.e(logTag, "Unexpected exception while getting app $id from remote", e)

            DomainResult.Failure(DomainError.UNKNOWN)
        }
    }

    fun putAppDetails(appDetails: AppDetails): DomainResult<Unit> {
        Log.d(logTag, "Putting app $appDetails")

        return try {
            dao.putAppDetails(appDetailsLocalMapper.toEntity(appDetails))
            DomainResult.Success(Unit)
        } catch (e: IOException) {
            Log.e(logTag, "Connection error while putting app $appDetails", e)

            DomainResult.Failure(DomainError.CONNECTION_ERROR)
        } catch (e: Exception) {
            Log.e(logTag, "Unexpected exception while putting app $appDetails", e)

            DomainResult.Failure(DomainError.UNKNOWN)
        }
    }
}
