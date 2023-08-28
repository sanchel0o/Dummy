package com.sanchelo.dummy.presentation

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.sanchelo.dummy.presentation.core.DummyTheme
import com.sanchelo.dummy.presentation.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint //if we have dependencies in android component class
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S){
            val splashScreen = installSplashScreen()
            splashScreen.setKeepOnScreenCondition { true }
        }
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            DummyTheme {
                Navigation()
            }
        }
    }
}
