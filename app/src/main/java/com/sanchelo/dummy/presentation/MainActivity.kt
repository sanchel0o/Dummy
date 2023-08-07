package com.sanchelo.dummy.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.sanchelo.dummy.presentation.core.DummyTheme
import com.sanchelo.dummy.presentation.product_list_screen.screen.ProductListScreen
import com.sanchelo.dummy.presentation.product_list_screen.screen.compose.TransparentSystemBars
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint //if we have dependencies in android component class
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            DummyTheme {
                TransparentSystemBars()
                ProductListScreen()
            }
        }
    }
}
