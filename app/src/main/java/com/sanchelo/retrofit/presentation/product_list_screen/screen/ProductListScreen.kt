package com.sanchelo.retrofit.presentation.product_list_screen.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.sanchelo.retrofit.presentation.product_list_screen.mvvm.ProductListEvents
import com.sanchelo.retrofit.presentation.product_list_screen.mvvm.ProductScreenListViewModel

@Composable
fun ProductListScreen() {
    val viewModel: ProductScreenListViewModel = hiltViewModel()
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
    ) {
        items(
            items = state.productData,
            key = { it.id }
        ) { item ->
            ProductCard(
                title = item.title,
                brand = item.brand,
                imageUrl = item.images[0],
                price = item.price,
                description = item.description,
                onClicked = { viewModel.onEvent(ProductListEvents.CardClick) }
            )
        }
    }
}

@Composable
//@Preview(showBackground = true)
fun ProductCard(
    title: String,
    brand: String,
    imageUrl: String,
    price: Int,
    description: String,
    onClicked: () -> Unit
) {
    Card(
        Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clickable { onClicked() },
        //colors = CardDefaults.cardColors(darkColorScheme(primary = )),
        elevation = CardDefaults.cardElevation(10.dp),
        shape = RoundedCornerShape(5.dp)
    ) {

        Column(modifier = Modifier.padding(8.dp)) {
            Row {
                ImageHeader(imageUrl)
                Column(
                    modifier = Modifier
                        .padding(start = 8.dp)
                ) {
                    Title(title)
                    Brand(brand)
                    Description(description)
                }
            }
            BottomBlock(price)
        }

    }
}

@Composable
fun ImageHeader(
    imageUrl: String
) {
    AsyncImage(
        modifier = Modifier.size(100.dp),
        contentScale = ContentScale.Fit,
        model = imageUrl,
        contentDescription = "Product Image"
    )
}

@Composable
fun Title(
    title: String
) {
    Text(
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        text = title
    )
}

@Composable
fun Brand(
    brand: String
) {
    Text(
        text = brand
    )
}

@Composable
fun Description(
    description: String
) {
    Text(
        fontWeight = FontWeight.Light,
        text = description
    )
}

@Composable
fun BottomBlock(
    price: Int
) {
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
                text = price.toString()
            )
            Column(
                Modifier.padding(5.dp)
            ) {
                Text(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.ExtraLight,
                    text = "-18 %"
                )
                Text(
                    style = TextStyle(
                        textDecoration = TextDecoration.LineThrough,
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold
                    ),
                    text = " 899 $"
                )
            }

        }
        Row {
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
