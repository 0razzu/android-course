package io.orazzu.android_course.presentation.viewmodel.app_details

import io.orazzu.android_course.domain.DomainError
import io.orazzu.android_course.domain.app_details.AppDetails

sealed interface AppDetailsUiState {
    data object Loading : AppDetailsUiState
    data class Success(val appDetails: AppDetails) : AppDetailsUiState
    data class Error(val error: DomainError) : AppDetailsUiState
}
