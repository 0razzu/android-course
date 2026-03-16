package io.orazzu.android_course.data.app

import android.util.Log
import io.orazzu.android_course.data.app_details.AppDetailsLocalApi
import io.orazzu.android_course.data.app_details.AppDetailsMapper
import io.orazzu.android_course.domain.app.App
import io.orazzu.android_course.domain.app.AppRepo

class AppLocalRepo(private val appMapper: AppMapper) : AppRepo {
    private val api = AppLocalApi()

    override suspend fun getApps(): List<App> {
        Log.d(this.javaClass.simpleName, "Getting apps")

        val appDtos = api.getApps()
        return appDtos.map { appMapper.toDomain(it) }
    }
}
