package io.orazzu.android_course

import android.content.Intent
import android.content.Intent.createChooser
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.core.net.toUri

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidCourseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TextPasser(
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}

@Composable
fun TextPasser(modifier: Modifier = Modifier) {
    val ctx = LocalContext.current
    var text by remember { mutableStateOf("Abc") }

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(24.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text(stringResource(R.string.TextPasser_textForSndActivity)) }
            )

            Button(onClick = {
                Log.d("SndActivityCallerButton", "Starting intent")
                ctx.startActivity(
                    Intent(ctx, SndActivity::class.java)
                        .addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
                        .putExtras(
                            Bundle().apply {
                                putString("text", text)
                            }
                        )
                )
            }) {
                Text(stringResource(R.string.TextPasser_openSndActivity))
            }

            Button(onClick = {
                if (text.isPhoneNumber) {
                    val intent = Intent(Intent.ACTION_DIAL)
                        .apply { data = "tel:$text".toUri() }

                    if (intent.resolveActivity(ctx.packageManager) != null) {
                        Log.d("CallFriendButton", "Starting intent")
                        ctx.startActivity(intent)
                    } else {
                        Toast.makeText(
                            ctx,
                            ctx.getString(R.string.TextPasser_noDialer),
                            Toast.LENGTH_SHORT,
                        ).show()
                    }
                } else {
                    Toast.makeText(
                        ctx,
                        ctx.getString(R.string.TextPasser_isNotPhoneNumber).format(text),
                        Toast.LENGTH_SHORT,
                    ).show()
                }
            }) {
                Text(stringResource(R.string.TextPasser_callFriend))
            }

            Button(onClick = {
                ctx.startActivity(
                    createChooser(
                        Intent(Intent.ACTION_SEND)
                            .apply { type = "text/plain" }
                            .putExtra(Intent.EXTRA_TEXT, text),
                        ctx.getString(R.string.TextPasser_shareText),
                    )
                )
            }) {
                Text(stringResource(R.string.TextPasser_shareText))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TextPasserPreview() {
    AndroidCourseTheme {
        TextPasser()
    }
}
