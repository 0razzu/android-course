package io.orazzu.android_course.presentation.viewmodel.app_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.orazzu.android_course.domain.DomainError
import io.orazzu.android_course.domain.DomainResult
import io.orazzu.android_course.domain.app_details.AppDetails
import io.orazzu.android_course.domain.app_details.AppDetailsRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AppDetailsViewModel(
    private val repository: AppDetailsRepo,
    private val appId: String?,
) : ViewModel() {
    private val _state = MutableStateFlow<AppDetailsUiState>(AppDetailsUiState.Loading)
    val state: StateFlow<AppDetailsUiState> = _state.asStateFlow()

    init {
        load()
    }

    private fun load() {
        if (appId == null) {
            _state.value = AppDetailsUiState.Error(DomainError.UNKNOWN)
            return
        }

        viewModelScope.launch {
            _state.value = when (val result = repository.getAppDetails(appId)) {
                is DomainResult.Success<AppDetails> -> AppDetailsUiState.Success(result.data)
                is DomainResult.Failure -> AppDetailsUiState.Error(result.error)
            }
        }
    }
}
