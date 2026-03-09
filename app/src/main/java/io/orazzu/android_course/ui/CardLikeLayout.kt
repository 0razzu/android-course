package io.orazzu.android_course.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import io.orazzu.android_course.R

@Composable
fun CardLikeLayout(
    modifier: Modifier = Modifier,
    header: @Composable BoxScope.() -> Unit,
    body: @Composable BoxScope.() -> Unit,
) {
    Column(
        modifier = modifier
            .background(colorResource(R.color.purple_500))
            .fillMaxSize(),
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 48.dp,
                    bottom = 16.dp,
                ),
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = modifier
                    .height(48.dp)
                    .fillMaxWidth(),
            ) {
                header()
            }
        }

        Box(
            modifier = modifier
                .fillMaxSize()
                .clip(
                    shape = RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 16.dp,
                        bottomStart = 0.dp,
                        bottomEnd = 0.dp,
                    )
                )
                .background(color = colorResource(R.color.white))
                .padding(16.dp),
        ) {
            body()
        }

    }
}
