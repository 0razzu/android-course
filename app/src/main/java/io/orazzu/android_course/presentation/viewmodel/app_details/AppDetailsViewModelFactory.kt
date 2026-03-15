package io.orazzu.android_course.presentation.viewmodel.app_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.orazzu.android_course.repository.AppRepository

class AppDetailsViewModelFactory(
    private val repository: AppRepository,
    private val appId: String?,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AppDetailsViewModel(repository, appId) as T
    }
}
