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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import io.orazzu.android_course.presentation.screens.app_list.AppListContentType
import io.orazzu.android_course.presentation.screens.app_list.AppListScreen
import io.orazzu.android_course.presentation.viewmodel.app_list.AppListEvent
import io.orazzu.android_course.presentation.viewmodel.app_list.AppListUiState
import io.orazzu.android_course.presentation.viewmodel.app_list.AppListViewModel
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppListRoute(
    onAppClick: (String) -> Unit,
) {
    val viewModel: AppListViewModel = hiltViewModel()

    val state by viewModel.state.collectAsState()

    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    val ctx = LocalContext.current

    LaunchedEffect(viewModel) {
        viewModel.events.collect { event ->
            when (event) {
                is AppListEvent.ShowSnackbar -> {
                    scope.launch {
                        snackbarHostState.showSnackbar(ctx.resources.getString(event.messageId))
                    }
                }
            }
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
    ) {
        AppListScreen(
            content = when (state) {
                is AppListUiState.Loading -> AppListContentType.Loading
                is AppListUiState.Success -> AppListContentType.WithApps((state as AppListUiState.Success).apps)
                is AppListUiState.Error -> AppListContentType.Error((state as AppListUiState.Error).error)
            },
            onAppClick = onAppClick,
            onLogoClick = viewModel::onLogoClick,
        )
    }
}
