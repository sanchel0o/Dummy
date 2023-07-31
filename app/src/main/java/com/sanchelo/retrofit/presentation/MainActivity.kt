package com.sanchelo.retrofit.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.sanchelo.retrofit.presentation.core.RetrofitTheme
import com.sanchelo.retrofit.presentation.product_list_screen.mvvm.ProductScreenListViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint //if we have dependencies in android component class
class MainActivity : ComponentActivity() {

    private val viewModel: ProductScreenListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getData()

        setContent {
            RetrofitTheme {
                //ProductListScreen()
                Home()


            }
        }
    }
}

@Composable
fun Home(
    //viewModel: ProductScreenListViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    )
}

