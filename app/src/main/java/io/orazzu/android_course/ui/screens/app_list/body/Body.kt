package io.orazzu.android_course.ui.screens.app_list.body

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import io.orazzu.android_course.R
import io.orazzu.android_course.model.app.AppDetails

@Composable
fun Body(
    modifier: Modifier = Modifier,
    apps: List<AppDetails>,
    onAppClick: (String) -> Unit,
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
    ) {
        itemsIndexed(apps) { i, app ->
            AppCard(modifier = modifier, app = app, onClick = { onAppClick(app.id) })
            if (i < apps.lastIndex) {
                HorizontalDivider(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = colorResource(R.color.gray_200),
                    thickness = 1.dp,
                )
            }
        }
    }
}
