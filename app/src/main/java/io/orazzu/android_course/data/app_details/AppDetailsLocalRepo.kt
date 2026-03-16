package io.orazzu.android_course.data.app_details

import android.util.Log
import io.orazzu.android_course.domain.app_details.AppDetails
import io.orazzu.android_course.domain.app_details.AppDetailsRepo

class AppDetailsLocalRepo(private val appDetailsMapper: AppDetailsMapper) : AppDetailsRepo {
    private val api = AppDetailsLocalApi()

    override suspend fun getAppDetails(id: String): AppDetails {
        Log.d(this.javaClass.simpleName, "Getting app $id")

        val appDetailsDto = api.getAppDetails(id)
        return appDetailsMapper.toDomain(appDetailsDto)
    }
}
