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
        Log.d(logTag, "Getting app $id from db")

        return when (val cached = withContext(Dispatchers.IO) { dao.getAppDetails(id) }) {
            is AppDetailsEntity -> DomainResult.Success(appDetailsLocalMapper.toDomain(cached))
            null -> refreshAppDetails(id)
        }
    }

    override suspend fun refreshAppDetails(id: String): DomainResult<AppDetails> {
        Log.d(logTag, "Refreshing app $id")

        return when (val appDetailsResp = withContext(Dispatchers.IO) {
            getAppDetailsFromRemote(id)
        }) {
            is DomainResult.Success -> {
                CoroutineScope(Dispatchers.IO).launch {
                    putAppDetails(appDetailsResp.data)
                }

                appDetailsResp
            }

            is DomainResult.Failure -> appDetailsResp
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

    suspend fun putAppDetails(appDetails: AppDetails): DomainResult<Unit> {
        Log.d(logTag, "Putting app $appDetails")

        return try {
            withContext(Dispatchers.IO) {
                dao.putAppDetails(appDetailsLocalMapper.toEntity(appDetails))
            }
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
