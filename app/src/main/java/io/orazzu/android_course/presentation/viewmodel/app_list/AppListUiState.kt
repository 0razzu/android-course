package io.orazzu.android_course.presentation.viewmodel.app_list

import io.orazzu.android_course.domain.DomainError
import io.orazzu.android_course.domain.app.App

sealed interface AppListUiState {
    data object Loading : AppListUiState
    data class Success(val apps: List<App>) : AppListUiState
    data class Error(val error: DomainError) : AppListUiState
}
