package io.orazzu.android_course.presentation.viewmodel.app_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.orazzu.android_course.R
import io.orazzu.android_course.model.app.AppDetails
import io.orazzu.android_course.repository.AppRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AppListViewModel(
    private val repository: AppRepository,
) : ViewModel() {
    private val _state = MutableStateFlow<List<AppDetails>>(emptyList())
    val state: StateFlow<List<AppDetails>> = _state.asStateFlow()

    private val _events = MutableSharedFlow<AppListEvent>()
    val events = _events.asSharedFlow()

    init {
        loadApps()
    }

    private fun loadApps() {
        _state.value = repository.getApps()
    }

    fun onLogoClick() {
        viewModelScope.launch {
            _events.emit(AppListEvent.ShowSnackbar(R.string.AppList_logoClicked))
        }
    }
}
