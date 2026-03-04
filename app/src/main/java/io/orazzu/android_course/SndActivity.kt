package io.orazzu.android_course

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.orazzu.android_course.ui.theme.AndroidCourseTheme

class SndActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidCourseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    IncomingTextContainer(
                        modifier = Modifier.padding(innerPadding),
                        text = intent.getStringExtra("text")
                    )
                }
            }
        }
    }
}

@Composable
fun IncomingTextContainer(modifier: Modifier = Modifier, text: String? = null) {
    Scaffold { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(24.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(text = text ?: stringResource(R.string.IncomingTextContainer_gotNoText))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IncomingTextContainerPreview() {
    AndroidCourseTheme {
        IncomingTextContainer()
    }
}
