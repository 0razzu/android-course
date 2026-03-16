package io.orazzu.android_course.domain.app_details

interface AppDetailsRepo {
    suspend fun getAppDetails(id: String): AppDetails
}
