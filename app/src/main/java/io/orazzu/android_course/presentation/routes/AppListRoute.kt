package io.orazzu.android_course.presentation.routes

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import io.orazzu.android_course.data.app.AppLocalRepo
import io.orazzu.android_course.data.app.AppMapper
import io.orazzu.android_course.data.app_category.AppCategoryMapper
import io.orazzu.android_course.presentation.screens.app_list.AppListContentType
import io.orazzu.android_course.presentation.screens.app_list.AppListScreen
import io.orazzu.android_course.presentation.viewmodel.app_list.AppListEvent
import io.orazzu.android_course.presentation.viewmodel.app_list.AppListUiState
import io.orazzu.android_course.presentation.viewmodel.app_list.AppListViewModel
import io.orazzu.android_course.presentation.viewmodel.app_list.AppListViewModelFactory

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppListRoute(
    onAppClick: (String) -> Unit,
) {
    val viewModel: AppListViewModel = viewModel(
        factory = AppListViewModelFactory(AppLocalRepo(AppMapper(AppCategoryMapper()))),
    )

    val state by viewModel.state.collectAsState()

    val snackbarHostState = remember { SnackbarHostState() }
    val ctx = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.events.collect { event ->
            when (event) {
                is AppListEvent.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(ctx.resources.getString(event.messageId))
                }
            }
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
    ) {
        AppListScreen(
            content = when (val curState = state) {
                is AppListUiState.Loading -> AppListContentType.Loading
                is AppListUiState.Success -> AppListContentType.WithApps(curState.apps)
                is AppListUiState.Error -> AppListContentType.Error(curState.error)
            },
            onAppClick = onAppClick,
            onLogoClick = viewModel::onLogoClick,
        )
    }
}
