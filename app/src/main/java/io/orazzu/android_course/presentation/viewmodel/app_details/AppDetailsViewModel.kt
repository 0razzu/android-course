package io.orazzu.android_course.presentation.viewmodel.app_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.orazzu.android_course.repository.AppRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.random.Random

class AppDetailsViewModel(
    private val repository: AppRepository,
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
            delay(Random.nextLong(2000))

            val app = repository.getApps().firstOrNull { it.id == appId }
            _state.value =
                if (app != null)
                    AppDetailsUiState.Success(app)
                else
                    AppDetailsUiState.Error
        }
    }
}
