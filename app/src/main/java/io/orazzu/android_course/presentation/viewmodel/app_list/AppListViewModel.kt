package io.orazzu.android_course.presentation.viewmodel.app_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.orazzu.android_course.R
import io.orazzu.android_course.domain.DomainResult
import io.orazzu.android_course.domain.app.App
import io.orazzu.android_course.domain.app.AppRepo
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AppListViewModel(
    private val repository: AppRepo,
) : ViewModel() {
    private val _state = MutableStateFlow<AppListUiState>(AppListUiState.Loading)
    val state: StateFlow<AppListUiState> = _state.asStateFlow()

    private val _events = MutableSharedFlow<AppListEvent>()
    val events = _events.asSharedFlow()

    init {
        loadApps()
    }

    private fun loadApps() {
        viewModelScope.launch {
            _state.value = when (val result = repository.getApps()) {
                is DomainResult.Success<List<App>> -> AppListUiState.Success(result.data)
                is DomainResult.Failure -> AppListUiState.Error(result.error)
            }
        }
    }

    fun onLogoClick() {
        viewModelScope.launch {
            _events.emit(AppListEvent.ShowSnackbar(R.string.AppList_logoClicked))
        }
    }
}
