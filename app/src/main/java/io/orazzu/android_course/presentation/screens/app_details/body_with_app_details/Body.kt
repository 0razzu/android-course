package io.orazzu.android_course.presentation.screens.app_details.body_with_app_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.orazzu.android_course.domain.app_details.AppDetails

@Composable
fun Body(modifier: Modifier = Modifier, app: AppDetails, onRefresh: () -> Unit) {
    PullToRefreshBox(
        isRefreshing = false,
        onRefresh = onRefresh,
        modifier = modifier,
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = modifier.fillMaxSize(),
        ) {
            item { Header(modifier = modifier, app = app) }
            item {
                Description(
                    modifier = modifier,
                    shortDescription = app.shortDescription,
                    longDescription = app.longDescription,
                )
            }
            item { InstallButton(modifier = modifier) }

            if (!app.screenshotUrlList.isEmpty()) {
                item { Spacer(modifier = modifier.height(8.dp)) }
                item {
                    Screenshots(
                        modifier = modifier,
                        screenshotUrls = app.screenshotUrlList,
                    )
                }
            }
        }
    }
}
