package io.orazzu.android_course.data.edu_catalog.app

import android.util.Log
import io.orazzu.android_course.data.edu_catalog.EduCatalogApi
import io.orazzu.android_course.domain.DomainError
import io.orazzu.android_course.domain.DomainResult
import io.orazzu.android_course.domain.app.App
import io.orazzu.android_course.domain.app.AppRepo
import javax.inject.Inject

class AppEduCatalogRepo @Inject constructor(
    private val appMapper: AppEduCatalogMapper,
    private val api: EduCatalogApi,
) : AppRepo {
    private val logTag = this.javaClass.simpleName

    override suspend fun getApps(): DomainResult<List<App>> {
        Log.d(logTag, "Getting apps")

        return try {
            val appDtos = api.getCatalog()
            DomainResult.Success(appDtos.map { appMapper.toDomain(it) })
        } catch (e: Exception) {
            Log.e(logTag, "Unexpected exception while getting apps", e)

            DomainResult.Failure(DomainError.UNKNOWN)
        }
    }
}
