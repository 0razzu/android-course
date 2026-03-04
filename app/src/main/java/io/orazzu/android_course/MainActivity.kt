package io.orazzu.android_course

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.orazzu.android_course.ui.theme.AndroidCourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidCourseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SndActivityCaller(
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}

@Composable
fun SndActivityCaller(modifier: Modifier = Modifier) {
    val ctx = LocalContext.current
    var textForSndActivity by remember { mutableStateOf("Abc") }

    Scaffold() { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(24.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = textForSndActivity,
                onValueChange = { textForSndActivity = it },
                label = { Text(stringResource(R.string.SndActivityCaller_textForSndActivity)) }
            )

            Button(onClick = {
                Log.i("SndActivityCallerButton", "Starting intent")
                ctx.startActivity(
                    Intent(ctx, SndActivity::class.java)
                        .addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                        .putExtras(
                            Bundle().apply {
                                putString("text", textForSndActivity)
                            }
                        )
                )
            }) {
                Text(stringResource(R.string.SndActivityCaller_openSndActivity))
            }

            Button(onClick = {}) {
                Text(stringResource(R.string.SndActivityCaller_shareText))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SndActivityCallerPreview() {
    AndroidCourseTheme {
        SndActivityCaller()
    }
}