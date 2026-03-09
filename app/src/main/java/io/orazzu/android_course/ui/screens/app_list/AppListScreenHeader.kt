package io.orazzu.android_course.ui.screens.app_list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.orazzu.android_course.R

@Composable
fun AppListScreenHeader(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
            .height(48.dp)
            .fillMaxWidth(),
    ) {
        Icon(
            modifier = modifier
                .size(40.dp)
                .background(
                    color = colorResource(R.color.white),
                    shape = RoundedCornerShape(10.dp),
                ),
            painter = painterResource(R.drawable.app_registration_40px),
            contentDescription = null,
            tint = colorResource(R.color.purple_500)
        )

        Text(
            text = stringResource(R.string.app_name),
            color = colorResource(R.color.white),
            fontSize = 28.sp,
            style = MaterialTheme.typography.titleLarge,
            overflow = TextOverflow.Ellipsis,
            modifier = modifier.weight(1f),
        )

        Icon(
            modifier = modifier
                .size(40.dp)
                .background(
                    color = colorResource(R.color.white_25),
                    shape = RoundedCornerShape(12.dp),
                )
                .clickable(onClick = {}),
            painter = painterResource(R.drawable.apps_40px),
            contentDescription = null,
            tint = colorResource(R.color.white),
        )
    }
}
