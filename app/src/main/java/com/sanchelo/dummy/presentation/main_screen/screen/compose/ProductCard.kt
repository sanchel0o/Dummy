package com.sanchelo.dummy.presentation.main_screen.screen.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductCard(
    cardId: Int,
    title: String,
    brand: String,
    imageUrl: String,
    price: Int,
    description: String,
    onClicked: () -> Unit,
    onAddToFavoritesClick: () -> Unit,
    favoritesCheckedStatus: Boolean
) {
    val id = remember {
        mutableStateOf(cardId)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        elevation = CardDefaults.cardElevation(5.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface),
        onClick = {

            onClicked()
        },
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
            BottomBlock(price, favoritesCheckedStatus, onAddToFavoritesClick)
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
    price: Int,
    favoritesCheckedStatus: Boolean,
    onAddToFavoritesClick: () -> Unit
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
            AddToFavouritesButton(favoritesCheckedStatus, onAddToFavoritesClick)
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
fun AddToFavouritesButton(
    checkedStatus: Boolean,
    onAddToFavoritesClick: () -> Unit
) {
    val checked = remember { mutableStateOf(checkedStatus) }
    IconToggleButton(
        checked = checkedStatus,
        onCheckedChange = {
            checked.value = it
            onAddToFavoritesClick()
        },
        enabled = true
    ) {
        if (checked.value) {
            Icon(
                Icons.Filled.ThumbUp,
                contentDescription = "",
                tint = MaterialTheme.colorScheme.primary
            )
        } else {
            Icon(
                Icons.Outlined.ThumbUp,
                contentDescription = "",
            )
        }
    }
}