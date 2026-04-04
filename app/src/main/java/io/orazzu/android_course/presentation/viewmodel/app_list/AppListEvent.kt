package io.orazzu.android_course.presentation.viewmodel.app_list

sealed interface AppListEvent {
    data class ShowSnackbar(val messageId: Int) : AppListEvent
}
