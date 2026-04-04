package io.orazzu.android_course.presentation.screens.app_details

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import io.orazzu.android_course.R
import io.orazzu.android_course.domain.DomainError
import io.orazzu.android_course.presentation.layouts.CardLikeLayout
import io.orazzu.android_course.presentation.preview_data.getAppDetails
import io.orazzu.android_course.presentation.screens.app_details.content_with_app_details.AppDetailsContent
import io.orazzu.android_course.presentation.screens.common.ErrorContent
import io.orazzu.android_course.presentation.screens.common.LoadingContent
import io.orazzu.android_course.presentation.theme.AndroidCourseTheme
import kotlin.random.Random

@Composable
fun AppDetailsScreen(
    modifier: Modifier = Modifier,
    content: AppDetailsContentType,
    onBackClick: () -> Unit,
) {
    CardLikeLayout(
        modifier = modifier,
        header = { AppDetailsScreenHeader(modifier = modifier, onBackClick = onBackClick) },
        content = {
            when (content) {
                is AppDetailsContentType.Loading -> LoadingContent(modifier = modifier)
                is AppDetailsContentType.WithAppDetails -> AppDetailsContent(modifier = modifier, app = content.appDetails)
                is AppDetailsContentType.Error -> ErrorContent(
                    modifier = modifier,
                    error = when (content.error) {
                        DomainError.NOT_FOUND -> stringResource(R.string.AppDetailsErrorScreen_appNotFound)
                        else -> stringResource(R.string.unknownError)
                    },
                )
            }
        },
    )
}

@Preview(showBackground = true)
@Composable
fun AppDetailsScreenPreview() {
    AndroidCourseTheme {
        val appDetails = getAppDetails()
        AppDetailsScreen(
            content = AppDetailsContentType.WithAppDetails(appDetails[Random.nextInt(appDetails.size)]),
            onBackClick = {},
        )
    }
}
