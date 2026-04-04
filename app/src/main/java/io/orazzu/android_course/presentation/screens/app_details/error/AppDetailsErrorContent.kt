package io.orazzu.android_course.presentation.screens.app_details.error

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.orazzu.android_course.R

@Composable
fun AppDetailsErrorContent(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize(),
    ) {
        Icon(
            modifier = modifier
                .padding(bottom = 12.dp)
                .size(48.dp),
            painter = painterResource(R.drawable.warning_48px),
            contentDescription = null,
            tint = colorResource(R.color.yellow_700),
        )

        Text(
            text = stringResource(R.string.AppDetailsErrorScreen_appNotFound),
            fontSize = 24.sp,
            style = MaterialTheme.typography.titleMedium,
            modifier = modifier,
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
    heightDp = 700,
    widthDp = 400,
)
@Composable
fun AppDetailsErrorContentPreview() {
    AppDetailsErrorContent()
}
