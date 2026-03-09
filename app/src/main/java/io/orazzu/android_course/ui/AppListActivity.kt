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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import io.orazzu.android_course.R
import io.orazzu.android_course.helpers.toString
import io.orazzu.android_course.model.app.AppDetails
import io.orazzu.android_course.repository.AppRepository
import io.orazzu.android_course.repository.local.AppLocalRepository
import io.orazzu.android_course.ui.theme.AndroidCourseTheme

class AppListActivity(
    private val appRepository: AppRepository = AppLocalRepository(),
) : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidCourseTheme {
                val navController = rememberNavController()
                val apps = appRepository.getApps()

                NavHost(
                    navController = navController,
                    startDestination = "app_list",
                ) {
                    composable("app_list") {
                        AppListScreen(
                            apps = apps,
                            onAppClick = { appId ->
                                navController.navigate("app_details/$appId")
                            },
                        )
                    }

                    composable("app_details/{appId}") { backStackEntry ->
                        val appId = backStackEntry.arguments?.getString("appId")
                        val app = apps.first { it.id == appId }

                        AppDetailsScreen(
                            app = app,
                            onBackClick = { navController.popBackStack() },
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun AppListScreen(
    modifier: Modifier = Modifier,
    apps: List<AppDetails>,
    onAppClick: (String) -> Unit,
) {
    CardLikeLayout(
        modifier = modifier,
        header = { AppListScreenHeader(modifier = modifier) },
        body = { AppListScreenAppList(modifier = modifier, apps = apps, onAppClick = onAppClick) },
    )
}

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

@Composable
fun AppListScreenAppList(
    modifier: Modifier = Modifier,
    apps: List<AppDetails>,
    onAppClick: (String) -> Unit,
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
    ) {
        itemsIndexed(apps) { i, app ->
            AppCard(modifier = modifier, app = app, onClick = { onAppClick(app.id) })
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
            .padding(vertical = 16.dp),
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

@Preview(showBackground = true)
@Composable
fun AppListScreenPreview() {
    AndroidCourseTheme {
        AppListScreen(apps = AppLocalRepository().getApps(), onAppClick = {})
    }
}
