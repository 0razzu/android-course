package io.orazzu.android_course.presentation.viewmodel.app_details

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.orazzu.android_course.data.app_details.AppDetailsLocalApi
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
            _state.value = AppDetailsUiState.Error
            return
        }

        viewModelScope.launch {
            try {
                val app = repository.getAppDetails(appId)
                _state.value = AppDetailsUiState.Success(app)
            } catch (e: AppDetailsLocalApi.NotFoundException) {
                Log.w(
                    this@AppDetailsViewModel.javaClass.simpleName,
                    "Failed getting app details",
                    e,
                )

                _state.value = AppDetailsUiState.Error
            }
        }
    }
}
