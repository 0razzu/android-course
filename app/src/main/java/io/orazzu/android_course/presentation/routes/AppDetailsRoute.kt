package io.orazzu.android_course.presentation.routes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import io.orazzu.android_course.presentation.screens.app_details.error.AppDetailsErrorScreen
import io.orazzu.android_course.presentation.screens.app_details.loading.AppDetailsLoadingScreen
import io.orazzu.android_course.presentation.screens.app_details.success.AppDetailsScreen
import io.orazzu.android_course.presentation.viewmodel.app_details.AppDetailsUiState
import io.orazzu.android_course.presentation.viewmodel.app_details.AppDetailsViewModel
import io.orazzu.android_course.presentation.viewmodel.app_details.AppDetailsViewModelFactory
import io.orazzu.android_course.repository.local.AppLocalRepository

@Composable
fun AppDetailsRoute(
    appId: String?,
    onBackClick: () -> Unit,
) {
    val viewModel: AppDetailsViewModel = viewModel(
        factory = AppDetailsViewModelFactory(
            AppLocalRepository(),
            appId,
        ),
    )

    val state by viewModel.state.collectAsState()
    when (state) {
        is AppDetailsUiState.Loading -> AppDetailsLoadingScreen(
            onBackClick = onBackClick,
        )

        is AppDetailsUiState.Success -> AppDetailsScreen(
            app = (state as AppDetailsUiState.Success).app,
            onBackClick = onBackClick,
        )

        is AppDetailsUiState.Error -> AppDetailsErrorScreen(
            onBackClick = onBackClick,
        )
    }
}
