package io.orazzu.android_course.presentation.screens.app_list

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import io.orazzu.android_course.R
import io.orazzu.android_course.domain.DomainError
import io.orazzu.android_course.presentation.layouts.CardLikeLayout
import io.orazzu.android_course.presentation.preview_data.getApps
import io.orazzu.android_course.presentation.screens.app_list.content_with_apps.AppListContent
import io.orazzu.android_course.presentation.screens.common.ErrorContent
import io.orazzu.android_course.presentation.screens.common.LoadingContent
import io.orazzu.android_course.presentation.theme.AndroidCourseTheme

@Composable
fun AppListScreen(
    modifier: Modifier = Modifier,
    content: AppListContentType,
    onAppClick: (String) -> Unit,
    onLogoClick: () -> Unit,
) {
    CardLikeLayout(
        modifier = modifier,
        header = { AppListScreenHeader(modifier = modifier, onLogoClick = onLogoClick) },
        content = {
            when (content) {
                is AppListContentType.Loading -> {
                    LoadingContent(modifier = modifier)
                }

                is AppListContentType.WithApps -> {
                    AppListContent(
                        modifier = modifier,
                        apps = content.apps,
                        onAppClick = onAppClick,
                    )
                }

                is AppListContentType.Error -> {
                    ErrorContent(
                        modifier = modifier,
                        error = when (content.error) {
                            DomainError.CONNECTION_ERROR -> stringResource(R.string.connectionError)
                            else -> stringResource(R.string.unknownError)
                        },
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
            content = AppListContentType.WithApps(getApps()),
            onAppClick = {},
            onLogoClick = {},
        )
    }
}
