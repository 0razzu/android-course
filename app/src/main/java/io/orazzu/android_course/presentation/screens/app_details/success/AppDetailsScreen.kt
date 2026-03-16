package io.orazzu.android_course.presentation.screens.app_details.success

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.orazzu.android_course.domain.app_details.AppDetails
import io.orazzu.android_course.presentation.layouts.CardLikeLayout
import io.orazzu.android_course.presentation.preview_data.getAppDetails
import io.orazzu.android_course.presentation.screens.app_details.AppDetailsScreenHeader
import io.orazzu.android_course.presentation.screens.app_details.success.body.Body
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
        body = { Body(modifier = modifier, app = app) },
    )
}

@Preview(showBackground = true)
@Composable
fun AppDetailsScreenPreview() {
    AndroidCourseTheme {
        val appDetails = getAppDetails()
        AppDetailsScreen(app = appDetails[Random.nextInt(appDetails.size)], onBackClick = {})
    }
}
