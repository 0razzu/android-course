package io.orazzu.android_course.presentation.viewmodel.app_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.orazzu.android_course.domain.DomainError
import io.orazzu.android_course.domain.DomainResult
import io.orazzu.android_course.domain.app_details.AppDetails
import io.orazzu.android_course.domain.app_details.AppDetailsRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppDetailsViewModel @Inject constructor(
    private val repository: AppDetailsRepo,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _state = MutableStateFlow<AppDetailsUiState>(AppDetailsUiState.Loading)
    val state: StateFlow<AppDetailsUiState> = _state.asStateFlow()

    private val appId: String? = savedStateHandle["appId"]

    init {
        if (appId == null) {
            _state.value = AppDetailsUiState.Error(DomainError.UNKNOWN)
        } else {
            getAppDetails(appId)  // initial load in case we don’t have it in db
            observeAppDetails(appId)
        }
    }

    fun onRefresh() {
        if (appId == null) {
            _state.value = AppDetailsUiState.Error(DomainError.UNKNOWN)
            return
        }

        viewModelScope.launch {
            refreshAppDetails(appId)
        }
    }

    fun onToggleWishlistStatus() {
        if (appId == null) {
            _state.value = AppDetailsUiState.Error(DomainError.UNKNOWN)
            return
        }

        viewModelScope.launch {
            repository.toggleWishlistStatus(appId)
        }
    }

    private fun getAppDetails(appId: String) {
        viewModelScope.launch {
            val result = repository.getAppDetails(appId)
            // no state update unless there is an error, observeAppDetails() will perform it anyways
            if (result is DomainResult.Failure) {
                _state.value = AppDetailsUiState.Error(result.error)
            }
        }
    }

    private fun observeAppDetails(appId: String) {
        viewModelScope.launch {
            repository.observeAppDetails(appId)
                .collect {
                    _state.value = when (it) {
                        is DomainResult.Success<AppDetails> -> AppDetailsUiState.Success(it.data)
                        is DomainResult.Failure -> AppDetailsUiState.Error(it.error)
                    }
                }
        }
    }

    private suspend fun refreshAppDetails(appId: String) {
        _state.value = AppDetailsUiState.Loading
        _state.value = when (val result = repository.refreshAppDetails(appId)) {
            is DomainResult.Success -> AppDetailsUiState.Success(result.data)
            is DomainResult.Failure -> AppDetailsUiState.Error(result.error)
        }
    }
}
