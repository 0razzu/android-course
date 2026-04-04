package io.orazzu.android_course.presentation.viewmodel.app_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.orazzu.android_course.domain.app_details.AppDetailsRepo

class AppDetailsViewModelFactory(
    private val repository: AppDetailsRepo,
    private val appId: String?,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AppDetailsViewModel(repository, appId) as T
    }
}
