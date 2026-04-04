package io.orazzu.android_course.domain.app_details

import io.orazzu.android_course.domain.DomainResult

interface AppDetailsRepo {
    suspend fun getAppDetails(id: String): DomainResult<AppDetails>
}
