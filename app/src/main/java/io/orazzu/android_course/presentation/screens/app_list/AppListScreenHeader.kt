package io.orazzu.android_course.presentation.screens.app_list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.orazzu.android_course.R

@Composable
fun AppListScreenHeader(
    modifier: Modifier = Modifier,
    onLogoClick: () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
            .height(48.dp)
            .fillMaxWidth(),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .height(48.dp)
                .weight(1f),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = modifier
                    .height(48.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .clickable(onClick = onLogoClick),
            ) {
                Icon(
                    modifier = modifier
                        .size(40.dp)
                        .background(
                            color = colorScheme.onPrimary,
                            shape = RoundedCornerShape(10.dp),
                        ),
                    painter = painterResource(R.drawable.app_registration_40px),
                    contentDescription = null,
                    tint = colorScheme.primary,
                )

                Text(
                    text = stringResource(R.string.app_name),
                    color = colorScheme.onPrimary,
                    fontSize = 28.sp,
                    style = MaterialTheme.typography.titleLarge,
                    overflow = TextOverflow.Ellipsis,
                    modifier = modifier
                        .padding(end = 10.dp),
                )
            }
        }

        Icon(
            modifier = modifier
                .size(40.dp)
                .background(
                    color = colorScheme.onPrimaryContainer,
                    shape = RoundedCornerShape(12.dp),
                )
                .clip(shape = RoundedCornerShape(12.dp))
                .clickable(onClick = {}),
            painter = painterResource(R.drawable.apps_40px),
            contentDescription = null,
            tint = colorScheme.onPrimary,
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF6200EE,
)
@Composable
fun AppListScreenHeaderPreview() {
    AppListScreenHeader(onLogoClick = {})
}
