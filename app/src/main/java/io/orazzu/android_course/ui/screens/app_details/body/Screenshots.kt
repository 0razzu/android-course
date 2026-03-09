package io.orazzu.android_course.ui.screens.app_details.body

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import io.orazzu.android_course.R

@Composable
fun Screenshots(modifier: Modifier = Modifier, screenshotUrls: List<String>) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
    ) {
        Text(
            text = stringResource(R.string.AppDetailsScreenshots_screenshots),
            fontSize = 24.sp,
            style = MaterialTheme.typography.titleMedium,
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items(screenshotUrls.size) { index ->
                AsyncImage(
                    model = screenshotUrls[index],
                    contentDescription = "${stringResource(R.string.AppDetailsScreenshots_screenshot)} $index",
                    modifier = Modifier
                        .height(220.dp)
                        .background(colorResource(R.color.gray_400)),
                    contentScale = ContentScale.Crop,
                )
            }
        }
    }
}
