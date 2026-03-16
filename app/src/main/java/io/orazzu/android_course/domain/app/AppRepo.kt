package io.orazzu.android_course.domain.app

interface AppRepo {
    suspend fun getApps(): List<App>
}
