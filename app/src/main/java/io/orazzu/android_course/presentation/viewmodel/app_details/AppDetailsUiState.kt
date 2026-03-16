package io.orazzu.android_course.presentation.viewmodel.app_details

import io.orazzu.android_course.domain.app_details.AppDetails

sealed interface AppDetailsUiState {
    data object Loading : AppDetailsUiState
    data class Success(val app: AppDetails) : AppDetailsUiState
    data object Error : AppDetailsUiState
}
