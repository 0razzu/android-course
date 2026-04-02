package io.orazzu.android_course.presentation.screens.app_details.content_with_app_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.orazzu.android_course.domain.app_details.AppDetails

@Composable
fun AppDetailsContent(modifier: Modifier = Modifier, app: AppDetails) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState()),
    ) {
        Header(modifier = modifier, app = app)
        Description(
            modifier = modifier,
            text = app.longDescription ?: app.shortDescription,
        )
        InstallButton(modifier = modifier)

        if (!app.screenshotUrlList.isEmpty()) {
            Spacer(modifier = modifier.height(8.dp))
            Screenshots(
                modifier = modifier,
                screenshotUrls = app.screenshotUrlList,
            )
        }
    }
}
