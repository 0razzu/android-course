package io.orazzu.android_course.presentation.screens.app_details

import io.orazzu.android_course.domain.DomainError
import io.orazzu.android_course.domain.app_details.AppDetails

sealed interface BodyType {
    data object Loading : BodyType
    data class WithAppDetails(val appDetails: AppDetails) : BodyType
    data class Error(val error: DomainError) : BodyType
}
