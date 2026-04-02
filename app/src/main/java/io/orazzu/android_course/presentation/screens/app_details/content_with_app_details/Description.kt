package io.orazzu.android_course.presentation.screens.app_details.content_with_app_details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.orazzu.android_course.R

@Composable
fun Description(
    modifier: Modifier = Modifier,
    text: String,
) {
    val paragraphs = text.split("\n")
    var expanded by rememberSaveable { mutableStateOf(false) }
    var overflown by rememberSaveable { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.padding(horizontal = 16.dp),
    ) {
        if (expanded) {
            paragraphs.forEach { paragraph ->
                Text(
                    text = paragraph,
                    color = colorScheme.onSurface,
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.bodyMedium,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        } else {
            Text(
                text = text,
                color = colorScheme.onSurface,
                fontSize = 16.sp,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 5,
                overflow = TextOverflow.Ellipsis,
                onTextLayout = {
                    overflown = it.didOverflowHeight
                },
            )
        }

        if (overflown) {
            Text(
                text = if (expanded)
                    stringResource(R.string.AppDetailsDescription_showLess) else
                    stringResource(R.string.AppDetailsDescription_showMore),
                color = colorScheme.tertiary,
                modifier = modifier.clickable {
                    expanded = !expanded
                },
            )
        }
    }
}
