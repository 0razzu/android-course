package io.orazzu.android_course.presentation.screens.app_list

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.orazzu.android_course.model.app.AppDetails
import io.orazzu.android_course.presentation.layouts.CardLikeLayout
import io.orazzu.android_course.presentation.screens.app_list.body.Body
import io.orazzu.android_course.presentation.theme.AndroidCourseTheme
import io.orazzu.android_course.repository.local.AppLocalRepository

@Composable
fun AppListScreen(
    modifier: Modifier = Modifier,
    apps: List<AppDetails>,
    onAppClick: (String) -> Unit,
    onLogoClick: () -> Unit,
) {
    CardLikeLayout(
        modifier = modifier,
        header = { AppListScreenHeader(modifier = modifier, onLogoClick = onLogoClick) },
        body = { Body(modifier = modifier, apps = apps, onAppClick = onAppClick) },
    )
}

@Preview(showBackground = true)
@Composable
fun AppListScreenPreview() {
    AndroidCourseTheme {
        AppListScreen(apps = AppLocalRepository().getApps(), onAppClick = {}, onLogoClick = {})
    }
}
