package com.github.giovannicmelo.composeshop.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.github.giovannicmelo.composeshop.R

val metropolisFontFamily = FontFamily(
    Font(R.font.metropolis_regular, FontWeight.Normal),
    Font(R.font.metropolis_medium, FontWeight.Medium),
    Font(R.font.metropolis_bold, FontWeight.Bold),
    Font(R.font.metropolis_semibold, FontWeight.SemiBold),
    Font(R.font.metropolis_black, FontWeight.Black),
)

// Set of Material typography styles to start with
val Typography = Typography(
    defaultFontFamily = metropolisFontFamily,
    h1 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 34.sp
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    ),
    body1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    subtitle1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp
    ),
    button = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
)