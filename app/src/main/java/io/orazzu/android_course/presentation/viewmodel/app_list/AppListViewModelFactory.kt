package io.orazzu.android_course.presentation.viewmodel.app_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.orazzu.android_course.domain.app.AppRepo

class AppListViewModelFactory(
    private val repository: AppRepo,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AppListViewModel(repository) as T
    }
}
