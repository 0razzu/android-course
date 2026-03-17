package io.orazzu.android_course.data.app_details

import android.util.Log
import io.orazzu.android_course.domain.DomainError
import io.orazzu.android_course.domain.DomainResult
import io.orazzu.android_course.domain.app_details.AppDetails
import io.orazzu.android_course.domain.app_details.AppDetailsRepo

class AppDetailsLocalRepo(private val appDetailsMapper: AppDetailsMapper) : AppDetailsRepo {
    private val logTag = this.javaClass.simpleName
    private val api = AppDetailsLocalApi()

    override suspend fun getAppDetails(id: String): DomainResult<AppDetails> {
        Log.d(logTag, "Getting app $id")

        return try {
            val appDetailsDto = api.getAppDetails(id)
            DomainResult.Success(appDetailsMapper.toDomain(appDetailsDto))
        } catch (e: AppDetailsLocalApi.NotFoundException) {
            Log.w(logTag, "App $id not found")

            DomainResult.Failure(DomainError.NOT_FOUND)
        } catch (e: Exception) {
            Log.e(logTag, "Unexpected exception while getting app $id", e)

            DomainResult.Failure(DomainError.UNKNOWN)
        }
    }
}
