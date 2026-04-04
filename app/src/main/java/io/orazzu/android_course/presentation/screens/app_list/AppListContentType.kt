package io.orazzu.android_course.presentation.screens.app_list

import io.orazzu.android_course.domain.DomainError
import io.orazzu.android_course.domain.app.App

sealed interface AppListContentType {
    data object Loading : AppListContentType
    data class WithApps(val apps: List<App>) : AppListContentType
    data class Error(val error: DomainError) : AppListContentType
}
