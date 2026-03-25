package io.orazzu.android_course.presentation.routes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import io.orazzu.android_course.presentation.screens.app_details.AppDetailsScreen
import io.orazzu.android_course.presentation.screens.app_details.BodyType
import io.orazzu.android_course.presentation.viewmodel.app_details.AppDetailsUiState
import io.orazzu.android_course.presentation.viewmodel.app_details.AppDetailsViewModel

@Composable
fun AppDetailsRoute(
    onBackClick: () -> Unit,
) {
    val viewModel: AppDetailsViewModel = hiltViewModel()

    val state by viewModel.state.collectAsState()
    AppDetailsScreen(
        body = when (state) {
            is AppDetailsUiState.Loading -> BodyType.Loading
            is AppDetailsUiState.Success -> BodyType.WithAppDetails((state as AppDetailsUiState.Success).appDetails)
            is AppDetailsUiState.Error -> BodyType.Error((state as AppDetailsUiState.Error).error)
        },
        onBackClick = onBackClick,
        onRefresh = viewModel::refresh,
    )
}
