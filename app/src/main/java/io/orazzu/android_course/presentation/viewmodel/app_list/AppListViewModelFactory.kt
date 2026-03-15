package io.orazzu.android_course.presentation.viewmodel.app_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.orazzu.android_course.repository.AppRepository

class AppListViewModelFactory(
    private val repository: AppRepository,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AppListViewModel(repository) as T
    }
}
