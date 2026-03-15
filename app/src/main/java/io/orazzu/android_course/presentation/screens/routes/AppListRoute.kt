package io.orazzu.android_course.presentation.screens.routes

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import io.orazzu.android_course.presentation.screens.app_list.AppListEvent
import io.orazzu.android_course.presentation.screens.app_list.AppListScreen
import io.orazzu.android_course.presentation.screens.app_list.AppListViewModel
import io.orazzu.android_course.presentation.screens.app_list.AppListViewModelFactory
import io.orazzu.android_course.repository.local.AppLocalRepository

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppListRoute(
    onAppClick: (String) -> Unit,
) {
    val viewModel: AppListViewModel = viewModel(
        factory = AppListViewModelFactory(AppLocalRepository()),
    )

    val apps by viewModel.state.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    val ctx = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.events.collect { event ->
            when (event) {
                is AppListEvent.ShowSnackbar ->
                    snackbarHostState.showSnackbar(ctx.resources.getString(event.messageId))
            }
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
    ) {
        AppListScreen(
            apps = apps,
            onAppClick = onAppClick,
            onLogoClick = viewModel::onLogoClick,
        )
    }
}
