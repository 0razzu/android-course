package io.orazzu.android_course.data.app

import android.util.Log
import io.orazzu.android_course.domain.DomainError
import io.orazzu.android_course.domain.DomainException
import io.orazzu.android_course.domain.app.App
import io.orazzu.android_course.domain.app.AppRepo

class AppLocalRepo(private val appMapper: AppMapper) : AppRepo {
    private val logTag = this.javaClass.simpleName
    private val api = AppLocalApi()

    override suspend fun getApps(): List<App> {
        Log.d(logTag, "Getting apps")

        try {
            val appDtos = api.getApps()
            return appDtos.map { appMapper.toDomain(it) }
        } catch (e: Exception) {
            Log.e(logTag, "Unexpected exception while getting apps", e)

            throw DomainException(DomainError.UNKNOWN, e)
        }
    }
}
