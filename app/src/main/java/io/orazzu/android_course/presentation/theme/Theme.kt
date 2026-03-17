package io.orazzu.android_course.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = Color.Purple500,
    onPrimary = Color.White,
    onPrimaryContainer = Color.White25,
    secondary = Color.Purple700,
    onSecondary = Color.White,
    onSecondaryFixed = Color.Gray400,
    tertiary = Color.Purple700,
    surface = Color.White,
    onSurface = Color.Black,
    onSurfaceVariant = Color.Gray400,
    inverseOnSurface = Color.Gray600,
    surfaceDim = Color.Gray200,
    onError = Color.Yellow700,
)

private val DarkColorScheme = darkColorScheme(
    primary = Color.Purple500,
    onPrimary = Color.White,
    onPrimaryContainer = Color.White25,
    secondary = Color.Purple700,
    onSecondary = Color.White,
    onSecondaryFixed = Color.Gray600,
    tertiary = Color.Purple300,
    surface = Color.Black,
    onSurface = Color.White,
    onSurfaceVariant = Color.Gray600,
    inverseOnSurface = Color.Gray400,
    surfaceDim = Color.Gray800,
    onError = Color.Yellow700,
)

@Composable
fun AndroidCourseTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        typography = Typography,
        content = content,
    )
}
