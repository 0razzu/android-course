package io.orazzu.android_course.presentation.viewmodel.app_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
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
import javax.inject.Inject

@HiltViewModel
class AppListViewModel @Inject constructor(
    private val repository: AppRepo,
) : ViewModel() {
    private val _state = MutableStateFlow<AppListUiState>(AppListUiState.Loading)
    val state: StateFlow<AppListUiState> = _state.asStateFlow()

    private val _events = MutableSharedFlow<AppListEvent>()
    val events = _events.asSharedFlow()

    init {
        viewModelScope.launch {
            load()
        }
    }

    fun onRefresh() {
        viewModelScope.launch {
            refresh()
        }
    }

    fun onLogoClick() {
        viewModelScope.launch {
            _events.emit(AppListEvent.ShowSnackbar(R.string.AppList_logoClicked))
        }
    }

    private suspend fun load() {
        _state.value = when (val result = repository.getApps()) {
            is DomainResult.Success<List<App>> -> AppListUiState.Success(result.data)
            is DomainResult.Failure -> AppListUiState.Error(result.error)
        }
    }

    private suspend fun refresh() {
        _state.value = AppListUiState.Loading
        load()
    }
}
