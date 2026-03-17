package io.orazzu.android_course.presentation.screens.app_list.body_with_apps

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import io.orazzu.android_course.domain.app.App
import io.orazzu.android_course.presentation.helpers.toString

@Composable
fun AppCard(
    modifier: Modifier = Modifier,
    app: App,
    onClick: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(128.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .clickable(onClick = onClick)
            .padding(16.dp),
    ) {
        AsyncImage(
            model = app.iconUrl,
            contentDescription = app.name,
            modifier = Modifier
                .size(72.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(colorScheme.onSurfaceVariant)
                .border(
                    width = .5.dp,
                    color = colorScheme.onSurfaceVariant,
                    shape = RoundedCornerShape(16.dp),
                ),
            contentScale = ContentScale.Crop,
        )

        Column {
            Text(
                text = app.name,
                color = colorScheme.onSurface,
                fontSize = 20.sp,
                maxLines = 1,
                style = MaterialTheme.typography.titleMedium,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = app.shortDescription,
                color = colorScheme.onSurface,
                maxLines = 1,
                style = MaterialTheme.typography.bodyMedium,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = app.category.toString(LocalContext.current),
                maxLines = 1,
                style = MaterialTheme.typography.labelSmall,
                color = colorScheme.inverseOnSurface,
                overflow = TextOverflow.Ellipsis,
                modifier = modifier.padding(top = 8.dp),
            )
        }
    }
}
