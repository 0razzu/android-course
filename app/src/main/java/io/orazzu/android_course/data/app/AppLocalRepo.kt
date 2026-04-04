package io.orazzu.android_course.data.app

import android.util.Log
import io.orazzu.android_course.domain.DomainError
import io.orazzu.android_course.domain.DomainResult
import io.orazzu.android_course.domain.app.App
import io.orazzu.android_course.domain.app.AppRepo
import javax.inject.Inject

class AppLocalRepo @Inject constructor(
    private val appMapper: AppMapper,
    private val api: AppLocalApi,
) : AppRepo {
    private val logTag = this.javaClass.simpleName

    override suspend fun getApps(): DomainResult<List<App>> {
        Log.d(logTag, "Getting apps")

        return try {
            val appDtos = api.getApps()
            DomainResult.Success(appDtos.map { appMapper.toDomain(it) })
        } catch (e: Exception) {
            Log.e(logTag, "Unexpected exception while getting apps", e)

            DomainResult.Failure(DomainError.UNKNOWN)
        }
    }
}
