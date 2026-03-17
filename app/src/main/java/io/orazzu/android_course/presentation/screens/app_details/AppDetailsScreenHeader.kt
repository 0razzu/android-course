package io.orazzu.android_course.presentation.screens.app_details

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import io.orazzu.android_course.R
import io.orazzu.android_course.presentation.theme.Color

@Composable
fun AppDetailsScreenHeader(
    modifier: Modifier = Modifier,
    showShareButton: Boolean = true,
    onBackClick: () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxSize(),
    ) {
        Icon(
            modifier = modifier
                .size(40.dp)
                .background(
                    color = Color.None,
                    shape = RoundedCornerShape(12.dp),
                )
                .clip(shape = RoundedCornerShape(12.dp))
                .clickable(onClick = onBackClick),
            painter = painterResource(R.drawable.arrow_back_40px),
            contentDescription = null,
            tint = colorScheme.onPrimary,
        )

        if (showShareButton) {
            Icon(
                modifier = modifier
                    .size(40.dp)
                    .background(
                        color = Color.None,
                        shape = RoundedCornerShape(12.dp),
                    )
                    .clip(shape = RoundedCornerShape(12.dp))
                    .clickable(onClick = {}),
                painter = painterResource(R.drawable.share_40px),
                contentDescription = null,
                tint = colorScheme.onPrimary,
            )
        }
    }
}
