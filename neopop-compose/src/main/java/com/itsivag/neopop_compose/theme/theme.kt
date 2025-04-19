package com.itsivag.neopop_compose.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

val DarkNeoPopColorScheme = darkColorScheme(
    primary = Black,
    onPrimary = White,
    primaryContainer = White,
    secondary = Black,
    onSecondary = Black,
    background = Black,
    surface = Black,
    onBackground = White,
    onSurface = White,
)

@Composable
fun NeoPopTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DarkNeoPopColorScheme,
//        typography = Typography,
//        shapes = Shapes,
        content = content
    )
}
