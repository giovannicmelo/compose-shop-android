package com.github.giovannicmelo.composeshop.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val composeShopColorPalette = lightColors(
    primary = Primary,
    primaryVariant = Primary,
    secondary = Black,
    background = Background,
    surface = White
)

@Composable
fun ComposeShopTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = composeShopColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}