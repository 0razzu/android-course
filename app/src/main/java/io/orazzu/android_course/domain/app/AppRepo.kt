package io.orazzu.android_course.domain.app

import io.orazzu.android_course.domain.DomainResult

interface AppRepo {
    suspend fun getApps(): DomainResult<List<App>>
}
