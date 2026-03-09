package io.orazzu.android_course.ui.screens.app_details

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.orazzu.android_course.model.app.AppDetails
import io.orazzu.android_course.repository.local.AppLocalRepository
import io.orazzu.android_course.ui.layouts.CardLikeLayout
import io.orazzu.android_course.ui.screens.app_details.body.Body
import io.orazzu.android_course.ui.theme.AndroidCourseTheme
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
        body = { Body(modifier = modifier, app = app) },
    )
}

@Preview(showBackground = true)
@Composable
fun AppDetailsScreenPreview() {
    AndroidCourseTheme {
        val apps = AppLocalRepository().getApps()
        AppDetailsScreen(app = apps[Random.nextInt(apps.size)], onBackClick = {})
    }
}
