package io.orazzu.android_course.presentation.screens.app_list

import io.orazzu.android_course.domain.DomainError
import io.orazzu.android_course.domain.app.App

sealed interface BodyType {
    data object Loading : BodyType
    data class WithApps(val apps: List<App>) : BodyType
    data class Error(val error: DomainError) : BodyType
}
