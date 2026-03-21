package io.orazzu.android_course.data.edu_catalog

import io.orazzu.android_course.data.edu_catalog.app.AppEduCatalogDto
import io.orazzu.android_course.data.edu_catalog.app_details.AppDetailsEduCatalogDto
import retrofit2.http.GET
import retrofit2.http.Path

interface EduCatalogApi {
    @GET("catalog")
    suspend fun getCatalog(): List<AppEduCatalogDto>

    @GET("catalog/{id}")
    suspend fun getAppById(@Path("id") id: String): AppDetailsEduCatalogDto
}
