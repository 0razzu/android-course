package io.orazzu.android_course.presentation.screens.app_details.success

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.orazzu.android_course.model.app.AppDetails
import io.orazzu.android_course.presentation.layouts.CardLikeLayout
import io.orazzu.android_course.presentation.preview_data.getApps
import io.orazzu.android_course.presentation.screens.app_details.common.AppDetailsScreenHeader
import io.orazzu.android_course.presentation.screens.app_details.success.content.AppDetailsContent
import io.orazzu.android_course.presentation.theme.AndroidCourseTheme
import kotlin.random.Random

@Composable
fun AppDetailsScreen(
    modifier: Modifier = Modifier,
    app: AppDetails,
    onBackClick: () -> Unit,
) {
    CardLikeLayout(
        modifier = modifier,
        header = { AppDetailsScreenHeader(modifier = modifier, onBackClick = onBackClick) },
        content = { AppDetailsContent(modifier = modifier, app = app) },
    )
}

@Preview(showBackground = true)
@Composable
fun AppDetailsScreenPreview() {
    AndroidCourseTheme {
        val apps = getApps()
        AppDetailsScreen(app = apps[Random.nextInt(apps.size)], onBackClick = {})
    }
}
