package io.orazzu.android_course

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.orazzu.android_course.ui.theme.AndroidCourseTheme

class AppListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidCourseTheme {
                AppListScreen()
            }
        }
    }
}

@Composable
fun AppListScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(colorResource(R.color.purple_500))
            .fillMaxSize(),
    ) {
        AppListScreenHeader(modifier = modifier)
        AppListScreenAppList(modifier = modifier)
    }
}

@Composable
fun AppListScreenHeader(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(16.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                modifier = modifier.size(48.dp),
                painter = painterResource(R.drawable.app_registration_48px),
                contentDescription = null,
                tint = colorResource(R.color.white)
            )

            Text(
                text = stringResource(R.string.app_name),
                color = colorResource(R.color.white),
                fontSize = 36.sp,
            )
        }

        Icon(
            modifier = modifier
                .size(48.dp)
                .background(
                    color = colorResource(R.color.white_50),
                    shape = RoundedCornerShape(12.dp),
                ),
            painter = painterResource(R.drawable.apps_48px),
            contentDescription = null,
            tint = colorResource(R.color.white),
        )
    }
}

@Composable
fun AppListScreenAppList(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .clip(shape = RoundedCornerShape(16.dp, 16.dp, 0.dp, 0.dp))
            .background(color = colorResource(R.color.white)),
    ) {

    }
}

@Preview(showBackground = true)
@Composable
fun AppListScreenPreview() {
    AndroidCourseTheme {
        AppListScreen()
    }
}