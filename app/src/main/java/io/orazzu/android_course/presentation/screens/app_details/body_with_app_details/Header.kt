package io.orazzu.android_course.presentation.screens.app_details.body_with_app_details

import androidx.compose.foundation.MarqueeSpacing
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import io.orazzu.android_course.R
import io.orazzu.android_course.domain.app_details.AppDetails
import io.orazzu.android_course.presentation.helpers.toString

@Composable
fun Header(modifier: Modifier = Modifier, app: AppDetails) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier.fillMaxSize(),
    ) {
        Row(
            modifier = modifier.padding(
                start = 16.dp,
                top = 16.dp,
                end = 16.dp,
                bottom = 0.dp,
            ),
        ) {
            Text(
                text = app.name,
                color = colorScheme.onSurface,
                fontSize = 24.sp,
                style = MaterialTheme.typography.titleMedium,
                modifier = modifier.fillMaxWidth(),
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.Top,
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        ) {
            AsyncImage(
                model = app.iconUrl,
                contentDescription = app.name,
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(28.dp))
                    .background(colorScheme.onSecondaryContainer)
                    .border(
                        width = .5.dp,
                        color = colorScheme.onSecondaryContainer,
                        shape = RoundedCornerShape(28.dp),
                    ),
                contentScale = ContentScale.Crop,
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = modifier.fillMaxWidth(),
            ) {
                Text(
                    text = app.category.toString(LocalContext.current),
                    maxLines = 1,
                    style = MaterialTheme.typography.labelSmall,
                    color = colorScheme.onSurfaceVariant,
                    overflow = TextOverflow.Ellipsis,
                    modifier = modifier.fillMaxWidth(),
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = modifier.fillMaxWidth(),
                ) {
                    Icon(
                        modifier = modifier.size(20.dp),
                        painter = painterResource(R.drawable.person_book_20px),
                        contentDescription = null,
                        tint = colorScheme.onSurface,
                    )
                    Text(
                        text = app.developer,
                        color = colorScheme.onSurface,
                        fontSize = 18.sp,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = modifier
                            .fillMaxWidth()
                            .basicMarquee(spacing = MarqueeSpacing(32.dp)),
                    )
                }

                Text(
                    text = "${app.ageRating}+",
                    fontSize = 16.sp,
                    maxLines = 1,
                    style = MaterialTheme.typography.labelSmall,
                    color = colorScheme.onSurfaceVariant,
                )
            }
        }
    }
}
