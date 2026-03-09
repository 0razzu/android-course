package io.orazzu.android_course.repository

import io.orazzu.android_course.model.app.AppDetails

interface AppRepository {
    fun getApps(): List<AppDetails>
}
