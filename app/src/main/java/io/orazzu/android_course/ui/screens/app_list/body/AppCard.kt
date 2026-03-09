package io.orazzu.android_course.ui.screens.app_list.body

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import io.orazzu.android_course.R
import io.orazzu.android_course.helpers.toString
import io.orazzu.android_course.model.app.AppDetails

@Composable
fun AppCard(
    modifier: Modifier = Modifier,
    app: AppDetails,
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
                .background(colorResource(R.color.gray_400))
                .border(
                    width = .5.dp,
                    color = colorResource(R.color.gray_400),
                    shape = RoundedCornerShape(16.dp),
                ),
            contentScale = ContentScale.Crop,
        )

        Column {
            Text(
                text = app.name,
                fontSize = 20.sp,
                maxLines = 1,
                style = MaterialTheme.typography.titleMedium,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = app.shortDescription,
                maxLines = 1,
                style = MaterialTheme.typography.bodyMedium,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = app.category.toString(LocalContext.current),
                maxLines = 1,
                style = MaterialTheme.typography.labelSmall,
                color = colorResource(R.color.gray_600),
                overflow = TextOverflow.Ellipsis,
                modifier = modifier.padding(top = 8.dp),
            )
        }
    }
}
