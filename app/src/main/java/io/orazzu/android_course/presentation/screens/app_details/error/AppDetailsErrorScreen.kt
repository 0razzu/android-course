package io.orazzu.android_course.presentation.screens.app_details.error

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.orazzu.android_course.presentation.layouts.CardLikeLayout
import io.orazzu.android_course.presentation.screens.app_details.common.AppDetailsScreenHeader

@Composable
fun AppDetailsErrorScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
) {
    CardLikeLayout(
        modifier = modifier,
        header = {
            AppDetailsScreenHeader(
                modifier = modifier,
                showShareButton = false,
                onBackClick = onBackClick,
            )
        },
        content = {
            AppDetailsErrorContent(modifier = modifier)
        },
    )
}


@Preview
@Composable
fun AppDetailsErrorScreenPreview() {
    AppDetailsErrorScreen(onBackClick = {})
}
