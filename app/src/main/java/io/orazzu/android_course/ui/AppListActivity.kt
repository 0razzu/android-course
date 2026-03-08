package io.orazzu.android_course.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import io.orazzu.android_course.model.app.AppCategory
import io.orazzu.android_course.model.app.AppDetails
import io.orazzu.android_course.ui.theme.AndroidCourseTheme

class AppListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidCourseTheme {
                AppListScreen(
                    apps = listOf(
                        AppDetails(
                            id = "13er23",
                            name = "Some App",
                            developer = "Some Bank",
                            category = AppCategory.FINANCE,
                            ageRating = 17,
                            iconUrl = "https://yavuzceliker.github.io/sample-images/image-7.jpg",
                            screenshotUrlList = listOf(),
                            description = "Just some",
                        ),
                        AppDetails(
                            id = "43fr",
                            name = "One More App",
                            developer = "Someone",
                            category = AppCategory.EDUCATION,
                            ageRating = 0,
                            iconUrl = "https://yavuzceliker.github.io/sample-images/image-410.jpg",
                            screenshotUrlList = listOf(),
                            description = "Just another",
                        ),
                        AppDetails(
                            id = "eg8u4a",
                            name = "An App With a Crazy Long Name–Who in the World Ever Comes up With Such Blankets?",
                            developer = "Some Studio That Names Its Apps Like They’re Emo Songs–and Even Names Itself That Way",
                            category = AppCategory.ENTERTAINMENT,
                            ageRating = 17,
                            iconUrl = "https://yavuzceliker.github.io/sample-images/image-910.jpg",
                            screenshotUrlList = listOf(),
                            description = "Our descriptions are also long as hell btw. Y’all never read them anyways tho.",
                        ),
                    )
                )
            }
        }
    }
}

@Composable
fun AppListScreen(
    modifier: Modifier = Modifier,
    apps: List<AppDetails>,
) {
    Column(
        modifier = modifier
            .background(colorResource(R.color.purple_500))
            .fillMaxSize(),
    ) {
        AppListScreenHeader(modifier = modifier)
        AppListScreenAppList(modifier = modifier, apps = apps)
    }
}

@Composable
fun AppListScreenHeader(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 48.dp,
                bottom = 16.dp,
            ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            Icon(
                modifier = modifier
                    .size(40.dp)
                    .background(
                        color = colorResource(R.color.white),
                        shape = RoundedCornerShape(10.dp),
                    ),
                painter = painterResource(R.drawable.app_registration_48px),
                contentDescription = null,
                tint = colorResource(R.color.purple_500)
            )

            Text(
                text = stringResource(R.string.app_name),
                color = colorResource(R.color.white),
                fontSize = 28.sp,
                style = MaterialTheme.typography.titleLarge,
            )
        }

        Icon(
            modifier = modifier
                .size(48.dp)
                .background(
                    color = colorResource(R.color.white_25),
                    shape = RoundedCornerShape(12.dp),
                ),
            painter = painterResource(R.drawable.apps_48px),
            contentDescription = null,
            tint = colorResource(R.color.white),
        )
    }
}

@Composable
fun AppListScreenAppList(
    modifier: Modifier = Modifier,
    apps: List<AppDetails>,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .clip(
                shape = RoundedCornerShape(
                    topStart = 16.dp,
                    topEnd = 16.dp,
                    bottomStart = 0.dp,
                    bottomEnd = 0.dp,
                )
            )
            .background(color = colorResource(R.color.white)),
    ) {
        itemsIndexed(apps) { i, app ->
            AppCard(modifier = modifier, app = app)
            if (i < apps.lastIndex) {
                HorizontalDivider(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = colorResource(R.color.gray_200),
                    thickness = 1.dp,
                )
            }
        }
    }
}

@Composable
fun AppCard(
    modifier: Modifier = Modifier,
    app: AppDetails,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(128.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .clickable(onClick = {})
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
                text = app.description,
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

@Preview(showBackground = true)
@Composable
fun AppListScreenPreview() {
    AndroidCourseTheme {
        AppListScreen(
            apps = listOf(
                AppDetails(
                    id = "13er23",
                    name = "Some App",
                    developer = "Some Bank",
                    category = AppCategory.FINANCE,
                    ageRating = 17,
                    iconUrl = "",
                    screenshotUrlList = listOf(),
                    description = "Just some",
                ),
                AppDetails(
                    id = "43fr",
                    name = "One More App",
                    developer = "Someone",
                    category = AppCategory.EDUCATION,
                    ageRating = 0,
                    iconUrl = "",
                    screenshotUrlList = listOf(),
                    description = "Just another",
                ),
                AppDetails(
                    id = "eg8u4a",
                    name = "An App With a Crazy Long Name–Who in the World Ever Comes up With Such Blankets?",
                    developer = "Some Studio That Names Its Apps Like They’re Emo Songs–and Even Names Itself That Way",
                    category = AppCategory.ENTERTAINMENT,
                    ageRating = 17,
                    iconUrl = "",
                    screenshotUrlList = listOf(),
                    description = "Our descriptions are also long as hell btw. Y’all never read them anyways tho.",
                ),
            )
        )
    }
}
