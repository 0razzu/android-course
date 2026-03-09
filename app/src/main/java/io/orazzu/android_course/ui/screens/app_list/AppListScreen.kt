package io.orazzu.android_course.ui.screens.app_list

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.orazzu.android_course.model.app.AppDetails
import io.orazzu.android_course.repository.local.AppLocalRepository
import io.orazzu.android_course.ui.layouts.CardLikeLayout
import io.orazzu.android_course.ui.screens.app_list.body.Body
import io.orazzu.android_course.ui.theme.AndroidCourseTheme

@Composable
fun AppListScreen(
    modifier: Modifier = Modifier,
    apps: List<AppDetails>,
    onAppClick: (String) -> Unit,
) {
    CardLikeLayout(
        modifier = modifier,
        header = { AppListScreenHeader(modifier = modifier) },
        body = { Body(modifier = modifier, apps = apps, onAppClick = onAppClick) },
    )
}

@Preview(showBackground = true)
@Composable
fun AppListScreenPreview() {
    AndroidCourseTheme {
        AppListScreen(apps = AppLocalRepository().getApps(), onAppClick = {})
    }
}
