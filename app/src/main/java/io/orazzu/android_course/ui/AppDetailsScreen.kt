package io.orazzu.android_course.ui

import androidx.compose.foundation.MarqueeSpacing
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import io.orazzu.android_course.R
import io.orazzu.android_course.helpers.toString
import io.orazzu.android_course.model.app.AppDetails
import io.orazzu.android_course.repository.local.AppLocalRepository
import io.orazzu.android_course.ui.theme.AndroidCourseTheme
import kotlin.random.Random

@Composable
fun AppDetailsScreen(
    modifier: Modifier = Modifier,
    app: AppDetails,
    onBackClick: () -> Unit,
) {
    CardLikeLayout(
        modifier = modifier,
        header = { AppDetailsScreenHeader(modifier = modifier, onBackClick = onBackClick) },
        body = { AppDetailsScreenAppDetails(modifier = modifier, app = app) },
    )
}

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

@Composable
fun AppDetailsScreenAppDetails(modifier: Modifier = Modifier, app: AppDetails) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier.fillMaxSize()
    ) {
        item { AppDetailsHeader(modifier = modifier, app = app) }
        item {
            AppDetailsDescription(
                modifier = modifier,
                shortDescription = app.shortDescription,
                longDescription = app.longDescription,
            )
        }
        item { InstallButton(modifier = modifier) }

        if (!app.screenshotUrlList.isEmpty()) {
            item { Spacer(modifier = modifier.height(8.dp)) }
            item {
                AppDetailsScreenshots(
                    modifier = modifier,
                    screenshotUrls = app.screenshotUrlList,
                )
            }
        }
    }
}

@Composable
fun AppDetailsHeader(modifier: Modifier = Modifier, app: AppDetails) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier.fillMaxSize(),
    ) {
        Row {
            Text(
                text = app.name,
                fontSize = 24.sp,
                style = MaterialTheme.typography.titleMedium,
                modifier = modifier.fillMaxWidth(),
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.Top,
            modifier = modifier
                .fillMaxWidth(),
        ) {
            AsyncImage(
                model = app.iconUrl,
                contentDescription = app.name,
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(28.dp))
                    .background(colorResource(R.color.gray_400))
                    .border(
                        width = .5.dp,
                        color = colorResource(R.color.gray_400),
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
                    color = colorResource(R.color.gray_600),
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
                        tint = colorResource(R.color.black),
                    )
                    Text(
                        text = app.developer,
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
                    color = colorResource(R.color.gray_600),
                )
            }
        }
    }
}

@Composable
fun AppDetailsDescription(
    modifier: Modifier = Modifier,
    shortDescription: String,
    longDescription: String?,
) {
    val text = longDescription ?: shortDescription
    val paragraphs = text.split("\n")
    var expanded by rememberSaveable { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        if (expanded) {
            paragraphs.forEach { paragraph ->
                Text(
                    text = paragraph,
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.bodyMedium,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        } else {
            Text(
                text = text,
                fontSize = 16.sp,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 5,
                overflow = TextOverflow.Ellipsis,
            )
        }

        if (text.length > shortDescription.length) {
            Text(
                text = if (expanded)
                    stringResource(R.string.AppDetailsDescription_showLess) else
                    stringResource(R.string.AppDetailsDescription_showMore),
                color = colorResource(R.color.purple_700),
                modifier = modifier.clickable {
                    expanded = !expanded
                }
            )
        }
    }
}

@Composable
fun InstallButton(modifier: Modifier = Modifier) {
    Button(
        onClick = {},
        shape = RoundedCornerShape(8.dp),
        contentPadding = PaddingValues(vertical = 12.dp),
        modifier = modifier.fillMaxWidth(),
        colors = ButtonColors(
            containerColor = colorResource(R.color.purple_700),
            contentColor = colorResource(R.color.white),
            disabledContainerColor = colorResource(R.color.gray_400),
            disabledContentColor = colorResource(R.color.white),
        ),
    ) {
        Text(
            text = stringResource(R.string.InstallButton_install),
            maxLines = 1,
            color = colorResource(R.color.white),
            overflow = TextOverflow.Ellipsis,

            )
    }
}


@Composable
fun AppDetailsScreenshots(modifier: Modifier = Modifier, screenshotUrls: List<String>) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier.fillMaxSize(),
    ) {
        Text(
            text = stringResource(R.string.AppDetailsScreenshots_screenshots),
            fontSize = 24.sp,
            style = MaterialTheme.typography.titleMedium,
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items(screenshotUrls.size) { index ->
                AsyncImage(
                    model = screenshotUrls[index],
                    contentDescription = "${stringResource(R.string.AppDetailsScreenshots_screenshot)} $index",
                    modifier = Modifier
                        .height(220.dp)
                        .background(colorResource(R.color.gray_400)),
                    contentScale = ContentScale.Crop,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppDetailsScreenPreview() {
    AndroidCourseTheme {
        val apps = AppLocalRepository().getApps()
        AppDetailsScreen(app = apps[Random.nextInt(apps.size)], onBackClick = {})
    }
}
