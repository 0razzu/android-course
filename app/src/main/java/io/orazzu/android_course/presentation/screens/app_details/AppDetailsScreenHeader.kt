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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.orazzu.android_course.R
import io.orazzu.android_course.presentation.theme.Color

@Composable
fun AppDetailsScreenHeader(
    modifier: Modifier = Modifier,
    isInWishlist: Boolean?,
    onBackClick: () -> Unit,
    onToggleWishlistStatusClick: () -> Unit,
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
            contentDescription = stringResource(R.string.AppDetailsScreenHeader_back),
            tint = colorScheme.onPrimary,
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            if (isInWishlist != null) {
                Icon(
                    modifier = modifier
                        .size(40.dp)
                        .background(
                            color = Color.None,
                            shape = RoundedCornerShape(12.dp),
                        )
                        .clip(shape = RoundedCornerShape(12.dp))
                        .clickable(onClick = onToggleWishlistStatusClick),
                    painter = if (isInWishlist)
                        painterResource(R.drawable.favorite_filled_40px) else
                        painterResource(R.drawable.favorite_40px),
                    contentDescription = if (isInWishlist)
                        stringResource(R.string.AppDetailsScreenHeader_appIsInWishlist) else
                        stringResource(R.string.AppDetailsScreenHeader_appIsNotInWishlist),
                    tint = colorScheme.onPrimary,
                )
            }

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

@Preview(
    showBackground = true,
    backgroundColor = 0xFF6200EE,
)
@Composable
fun AppDetailsScreenHeaderPreview() {
    AppDetailsScreenHeader(
        isInWishlist = false,
        onBackClick = {},
        onToggleWishlistStatusClick = {},
    )
}
