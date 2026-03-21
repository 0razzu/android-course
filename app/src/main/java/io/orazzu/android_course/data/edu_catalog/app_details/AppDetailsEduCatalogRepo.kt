package io.orazzu.android_course.data.edu_catalog.app_details

import android.util.Log
import io.orazzu.android_course.data.edu_catalog.EduCatalogApi
import io.orazzu.android_course.domain.DomainError
import io.orazzu.android_course.domain.DomainResult
import io.orazzu.android_course.domain.app_details.AppDetails
import io.orazzu.android_course.domain.app_details.AppDetailsRepo
import retrofit2.HttpException
import java.io.IOException
import java.net.HttpURLConnection.HTTP_NOT_FOUND
import javax.inject.Inject

class AppDetailsEduCatalogRepo @Inject constructor(
    private val appDetailsMapper: AppDetailsEduCatalogMapper,
    private val api: EduCatalogApi,
) : AppDetailsRepo {
    private val logTag = this.javaClass.simpleName

    override suspend fun getAppDetails(id: String): DomainResult<AppDetails> {
        Log.d(logTag, "Getting app $id")

        return try {
            val appDetailsDto = api.getAppById(id)
            DomainResult.Success(appDetailsMapper.toDomain(appDetailsDto))
        } catch (e: HttpException) {
            if (e.code() == HTTP_NOT_FOUND) {
                Log.w(logTag, "App $id not found", e)

                DomainResult.Failure(DomainError.NOT_FOUND)
            } else {
                throw e
            }
        } catch (e: IOException) {
            Log.e(logTag, "Connection error while getting app $id", e)

            DomainResult.Failure(DomainError.CONNECTION_ERROR)
        } catch (e: Exception) {
            Log.e(logTag, "Unexpected exception while getting app $id", e)

            DomainResult.Failure(DomainError.UNKNOWN)
        }
    }
}
