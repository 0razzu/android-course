package io.orazzu.android_course.presentation.screens.app_list

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import io.orazzu.android_course.R
import io.orazzu.android_course.domain.DomainError
import io.orazzu.android_course.presentation.layouts.CardLikeLayout
import io.orazzu.android_course.presentation.preview_data.getApps
import io.orazzu.android_course.presentation.screens.app_list.body_with_apps.Body
import io.orazzu.android_course.presentation.screens.common.ErrorBody
import io.orazzu.android_course.presentation.screens.common.LoadingBody
import io.orazzu.android_course.presentation.theme.AndroidCourseTheme

@Composable
fun AppListScreen(
    modifier: Modifier = Modifier,
    body: BodyType,
    onAppClick: (String) -> Unit,
    onLogoClick: () -> Unit,
    onRefresh : () -> Unit,
) {
    CardLikeLayout(
        modifier = modifier,
        header = { AppListScreenHeader(modifier = modifier, onLogoClick = onLogoClick) },
        body = {
            when (body) {
                is BodyType.Loading -> {
                    LoadingBody(modifier = modifier)
                }

                is BodyType.WithApps -> {
                    Body(modifier = modifier, apps = body.apps, onAppClick = onAppClick)
                }

                is BodyType.Error -> {
                    ErrorBody(
                        modifier = modifier,
                        error = when (body.error) {
                            DomainError.CONNECTION_ERROR -> stringResource(R.string.connectionError)
                            else -> stringResource(R.string.unknownError)
                        },
                        onRefresh = onRefresh,
                    )
                }
            }
        },
    )
}

@Preview(showBackground = true)
@Composable
fun AppListScreenPreview() {
    AndroidCourseTheme {
        AppListScreen(
            body = BodyType.WithApps(getApps()),
            onAppClick = {},
            onLogoClick = {},
            onRefresh = {},
        )
    }
}
