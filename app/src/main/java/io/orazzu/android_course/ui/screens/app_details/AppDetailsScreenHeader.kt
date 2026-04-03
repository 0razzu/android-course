package io.orazzu.android_course.ui.screens.app_details

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import io.orazzu.android_course.R

@Composable
fun AppDetailsScreenHeader(
    modifier: Modifier = Modifier,
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
                .clickable(onClick = onBackClick)
                .background(
                    color = colorResource(R.color.none),
                    shape = RoundedCornerShape(12.dp),
                ),
            painter = painterResource(R.drawable.arrow_back_40px),
            contentDescription = null,
            tint = colorResource(R.color.white),
        )

        Icon(
            modifier = modifier
                .size(40.dp)
                .clickable(onClick = {})
                .background(
                    color = colorResource(R.color.none),
                    shape = RoundedCornerShape(12.dp),
                ),
            painter = painterResource(R.drawable.share_40px),
            contentDescription = null,
            tint = colorResource(R.color.white),
        )
    }
}
