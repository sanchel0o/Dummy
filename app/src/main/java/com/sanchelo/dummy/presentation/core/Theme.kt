package com.sanchelo.dummy.presentation.core

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = DarkBlue,
    onPrimary = PaleBlue,
    secondary = VioletBlue,
    onSecondary = White,
    tertiary = LightPink,
    onTertiary = DarkBlue,
    surface = DarkGray,
    onSurface = SemiBlack,
    surfaceVariant = Gray,
    background = DarkGray,
    onBackground = SemiBlack,
    outline = PaleGray,
)

private val LightColorScheme = lightColorScheme(
    primary = primary,
    onPrimary = White,
    primaryContainer = PaleBlue,
    onPrimaryContainer = DeepBlue,
    secondary = secondary,
    onSecondary = LightPink,
    onSecondaryContainer = DeepDarkBlue,
    tertiary = tertiary,
    onTertiary = White,
    tertiaryContainer = PaleGreen,
    onTertiaryContainer = GrassGreen,
    surface = White,
    surfaceTint = White,
    onSurface = DarkBlue,
    onSurfaceVariant = DarkBlue,
    background = White,
    onBackground = DarkBlue,
    outline = DarkBlue,


    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun DummyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current

    SideEffect {
        val window = (view.context as Activity).window
        window.statusBarColor = Color.Transparent.toArgb()
        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
    }


    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}