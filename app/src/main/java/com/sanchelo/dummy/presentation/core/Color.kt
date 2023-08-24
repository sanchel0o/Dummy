package com.sanchelo.dummy.presentation.core

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode


//Light Color Scheme
val primaryLight = Color(0xFF95BDFF)
val onPrimaryLight = Color(0xFFFFFBFE)
val primaryContainerLight = Color(0xFFD5E3FF)
val onPrimaryContainerLight = Color(0xFF001B3C)
val secondaryLight = Color(0xFFB4E4FF)
val onSecondaryLight = Color(0xFFF7C8E0)
val onSecondaryContainerLight = Color(0xFF001E2B)
val tertiaryLight = Color(0xFF006B5E)
val tertiaryContainerLight = Color(0xFF76F8E1)
val onTertiaryContainerLight = Color(0xFF00201B)
val onSurfaceLight = Color(0xFF0B2447)
val onSurfaceVariantLight = Color(0xFF576CBC)
val outlineLight = Color(0xFFC0C9CC)
val surfaceLight = Color(0xFFFFFBFE)

//Dark Color Scheme
val primaryDark = Color(0xFFAAC7FF)
val onPrimaryDark = Color(0xFFFFFFFF)
val primaryContainerDark = Color(0xFFD6E3FF)
val onPrimaryContainerDark = Color(0xFF001B3E)
val secondaryDark = Color(0xFF3795BD)
val onSecondaryDark = Color(0xFFFFFFFF)
val secondaryContainerDark = Color(0xFF001E2B)
val onSecondaryContainerDark = Color(0xFFC1E8FF)
val tertiaryDark = Color(0xFF9B4052)
val onTertiaryDark = Color(0xFFFFFFFF)
val tertiaryContainerDark = Color(0xFFFFD9DD)
val onTertiaryContainerDark = Color(0xFF400013)
val surfaceDark = Color(0xFF1A1b1E)
val onSurfaceDark = Color(0xFFE3E2E6)
val surfaceVariantDark = Color(0xFF44474E)
val backgroundDark = Color(0xFF1A1B1E)
val onBackgroundDark = Color(0xFFE3E2E6)
val outlineDark = Color(0xFFC0C9CC)

val VioletBlue = Color(0xFF576CBC)


//Gradient colors
val backgroundGradientLight = Brush.linearGradient(
    colors = listOf(primaryLight, VioletBlue, tertiaryLight),
    start = Offset.Zero,
    end = Offset.Infinite,
    tileMode = TileMode.Clamp
)

val backgroundGradientDark = Brush.linearGradient(listOf(secondaryDark, VioletBlue, tertiaryDark))

//val loginButtonGradientColor = Brush.linearGradient(listOf(primaryLight, VioletBlue, tertiaryDark))

val loginTextGradientColor = Brush.linearGradient(listOf(primaryLight, VioletBlue, tertiaryDark))

