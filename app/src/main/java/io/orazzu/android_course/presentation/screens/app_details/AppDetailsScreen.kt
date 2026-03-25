package io.orazzu.android_course.presentation.screens.app_details

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import io.orazzu.android_course.R
import io.orazzu.android_course.domain.DomainError
import io.orazzu.android_course.presentation.layouts.CardLikeLayout
import io.orazzu.android_course.presentation.preview_data.getAppDetails
import io.orazzu.android_course.presentation.screens.app_details.body_with_app_details.Body
import io.orazzu.android_course.presentation.screens.common.ErrorBody
import io.orazzu.android_course.presentation.screens.common.LoadingBody
import io.orazzu.android_course.presentation.theme.AndroidCourseTheme
import kotlin.random.Random

@Composable
fun AppDetailsScreen(
    modifier: Modifier = Modifier,
    body: BodyType,
    onBackClick: () -> Unit,
    onRefresh: () -> Unit,
) {
    CardLikeLayout(
        modifier = modifier,
        header = { AppDetailsScreenHeader(modifier = modifier, onBackClick = onBackClick) },
        body = {
            when (body) {
                is BodyType.Loading -> LoadingBody(modifier = modifier)

                is BodyType.WithAppDetails -> Body(
                    modifier = modifier,
                    app = body.appDetails,
                    onRefresh = onRefresh,
                )

                is BodyType.Error -> ErrorBody(
                    modifier = modifier,
                    error = when (body.error) {
                        DomainError.CONNECTION_ERROR -> stringResource(R.string.connectionError)
                        DomainError.NOT_FOUND -> stringResource(R.string.AppDetailsErrorScreen_appNotFound)
                        else -> stringResource(R.string.unknownError)
                    },
                    onRefresh = onRefresh,
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
            body = BodyType.WithAppDetails(appDetails[Random.nextInt(appDetails.size)]),
            onBackClick = {},
            onRefresh = {},
        )
    }
}
