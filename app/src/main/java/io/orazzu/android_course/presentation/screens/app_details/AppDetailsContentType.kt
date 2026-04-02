package io.orazzu.android_course.presentation.screens.app_details

import io.orazzu.android_course.domain.DomainError
import io.orazzu.android_course.domain.app_details.AppDetails

sealed interface AppDetailsContentType {
    data object Loading : AppDetailsContentType
    data class WithAppDetails(val appDetails: AppDetails) : AppDetailsContentType
    data class Error(val error: DomainError) : AppDetailsContentType
}
