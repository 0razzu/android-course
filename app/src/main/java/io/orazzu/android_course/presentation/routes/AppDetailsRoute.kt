package io.orazzu.android_course.presentation.routes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import io.orazzu.android_course.data.app_category.AppCategoryMapper
import io.orazzu.android_course.data.app_details.AppDetailsLocalRepo
import io.orazzu.android_course.data.app_details.AppDetailsMapper
import io.orazzu.android_course.presentation.screens.app_details.AppDetailsScreen
import io.orazzu.android_course.presentation.screens.app_details.BodyType
import io.orazzu.android_course.presentation.viewmodel.app_details.AppDetailsUiState
import io.orazzu.android_course.presentation.viewmodel.app_details.AppDetailsViewModel
import io.orazzu.android_course.presentation.viewmodel.app_details.AppDetailsViewModelFactory

@Composable
fun AppDetailsRoute(
    appId: String?,
    onBackClick: () -> Unit,
) {
    val viewModel: AppDetailsViewModel = viewModel(
        factory = AppDetailsViewModelFactory(
            AppDetailsLocalRepo(AppDetailsMapper(AppCategoryMapper())),
            appId,
        ),
    )

    val state by viewModel.state.collectAsState()
    AppDetailsScreen(
        body = when (state) {
            is AppDetailsUiState.Loading -> BodyType.Loading
            is AppDetailsUiState.Success -> BodyType.WithAppDetails((state as AppDetailsUiState.Success).appDetails)
            is AppDetailsUiState.Error -> BodyType.Error((state as AppDetailsUiState.Error).error)
        },
        onBackClick = onBackClick,
    )
}
