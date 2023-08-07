package com.sanchelo.retrofit.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.sanchelo.retrofit.presentation.core.RetrofitTheme
import com.sanchelo.retrofit.presentation.product_list_screen.screen.ProductListScreen
import com.sanchelo.retrofit.presentation.product_list_screen.screen.compose.TransparentSystemBars
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint //if we have dependencies in android component class
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            RetrofitTheme {
                TransparentSystemBars()
                ProductListScreen()
            }
        }
    }
}
