package io.orazzu.android_course.ui.screens.app_details.body

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import io.orazzu.android_course.R

@Composable
fun InstallButton(modifier: Modifier = Modifier) {
    Button(
        onClick = {},
        shape = RoundedCornerShape(8.dp),
        contentPadding = PaddingValues(vertical = 12.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
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
