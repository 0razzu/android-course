package io.orazzu.android_course.data.app_details

import android.util.Log
import io.orazzu.android_course.domain.DomainError
import io.orazzu.android_course.domain.DomainException
import io.orazzu.android_course.domain.app_details.AppDetails
import io.orazzu.android_course.domain.app_details.AppDetailsRepo

class AppDetailsLocalRepo(private val appDetailsMapper: AppDetailsMapper) : AppDetailsRepo {
    private val logTag = this.javaClass.simpleName
    private val api = AppDetailsLocalApi()

    override suspend fun getAppDetails(id: String): AppDetails {
        Log.d(logTag, "Getting app $id")

        try {
            val appDetailsDto = api.getAppDetails(id)
            return appDetailsMapper.toDomain(appDetailsDto)
        } catch (e: AppDetailsLocalApi.NotFoundException) {
            Log.w(logTag, "App $id not found")

            throw DomainException(DomainError.NOT_FOUND, e)
        } catch (e: Exception) {
            Log.e(logTag, "Unexpected exception while getting app $id", e)

            throw DomainException(DomainError.UNKNOWN, e)
        }
    }
}
