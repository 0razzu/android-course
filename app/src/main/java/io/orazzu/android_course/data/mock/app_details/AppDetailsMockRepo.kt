package io.orazzu.android_course.data.mock.app_details

import android.util.Log
import io.orazzu.android_course.domain.DomainError
import io.orazzu.android_course.domain.DomainResult
import io.orazzu.android_course.domain.app_details.AppDetails
import io.orazzu.android_course.domain.app_details.AppDetailsRepo
import javax.inject.Inject

class AppDetailsMockRepo @Inject constructor(
    private val appDetailsMapper: AppDetailsMockMapper,
    private val api: AppDetailsMockApi,
) : AppDetailsRepo {
    private val logTag = this.javaClass.simpleName

    override suspend fun getAppDetails(id: String): DomainResult<AppDetails> {
        Log.d(logTag, "Getting app $id")

        return try {
            val appDetailsDto = api.getAppDetails(id)
            DomainResult.Success(appDetailsMapper.toDomain(appDetailsDto))
        } catch (e: AppDetailsMockApi.NotFoundException) {
            Log.w(logTag, "App $id not found", e)

            DomainResult.Failure(DomainError.NOT_FOUND)
        } catch (e: Exception) {
            Log.e(logTag, "Unexpected exception while getting app $id", e)

            DomainResult.Failure(DomainError.UNKNOWN)
        }
    }
}
