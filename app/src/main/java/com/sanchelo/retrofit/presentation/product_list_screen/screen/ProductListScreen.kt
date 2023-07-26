package com.sanchelo.retrofit.presentation.product_list_screen.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sanchelo.retrofit.presentation.product_list_screen.mvi.ProductListScreenViewModel

@Composable
//@Preview(showBackground = true)
fun ProductListScreen() {
    val viewModel: ProductListScreenViewModel = hiltViewModel()
}

@Composable
fun ProductList() {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        items(10) {
            ProductCard()
        }
    }
}


@Composable
//@Preview(showBackground = true)
fun ProductCard() {
    Card(
        Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .background(Color.White),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column {
                Row() {
                    ImageHeader()
                    Column(
                        modifier = Modifier
                            .padding(start = 8.dp)
                    ) {
                        Title()
                        Brand()
                        Description()
                    }
                }
                BottomBlock()
            }
        }
    }
}

@Composable
@Preview
fun Toolbar() {
    Row(
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Text(text = "Toolbar")
    }
}

@Composable
fun ImageHeader() {
    Image(
        modifier = Modifier.size(100.dp),
        contentScale = ContentScale.Fit,
        painter = painterResource(id = androidx.core.R.drawable.ic_call_decline),
        contentDescription = ""
    )
}

@Composable
fun Title() {
    Text(
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        text = "Apple"
    )
}

@Composable
fun Brand() {
    Text(
        text = "iPhone X"
    )
}

@Composable
fun Description() {
    Text(
        fontWeight = FontWeight.Light,
        text = "SIM-Free, Model A19211 6.5-inch Super Retina HD display with OLED technology A12 Bionic chip with ..."
    )
}

@Composable
fun BottomBlock() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(Modifier.padding(start = 16.dp)) {
            Text(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                text = "899 $"
            )
            Text(
                modifier = Modifier
                    .padding(start = 5.dp),
                fontSize = 15.sp,
                fontWeight = FontWeight.ExtraLight,
                text = "-17.94 %"
            )
        }
        Row() {
            AddToFavouritesButton()
            AddToCartButton()
        }
    }
}

@Composable
fun AddToCartButton() {
    IconButton(
        modifier = Modifier,
        onClick = { /*TODO*/ }
    ) {
        Icon(Icons.Outlined.ShoppingCart, contentDescription = "Add to cart")
    }
}

@Composable
fun AddToFavouritesButton() {

    IconButton(
        onClick = { /*TODO*/ }
    ) {
        Icon(Icons.Outlined.ThumbUp, contentDescription = "Add to favourites")
    }
}

@Composable
@Preview
private fun ProductListPreview() {
    ProductList()
}




