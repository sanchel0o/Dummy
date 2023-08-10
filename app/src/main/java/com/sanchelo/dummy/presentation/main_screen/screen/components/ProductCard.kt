package com.sanchelo.dummy.presentation.main_screen.screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
    onCardClicked: (Int) -> Unit,
    cartCheckedStatus: Boolean,
    onAddToFavoritesClick: () -> Unit,
    favoritesCheckedStatus: Boolean,
    onAddToCartClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        elevation = CardDefaults.cardElevation(5.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface),
        onClick = {
            onCardClicked(cardId)
        },
    ) {
        Column(modifier = Modifier.padding(4.dp)) {
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
            BottomBlock(price, favoritesCheckedStatus, onAddToFavoritesClick, cartCheckedStatus, onAddToCartClick)
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
    onAddToFavoritesClick: () -> Unit,
    cartCheckedStatus: Boolean,
    onAddToCartClick: () -> Unit
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
            AddToCartButton(cartCheckedStatus, onAddToCartClick)
        }
    }
}

@Composable
fun AddToCartButton(
    checkedStatus: Boolean,
    onAddToCartClick: () -> Unit
) {
    IconToggleButton(
        checked = checkedStatus,
        onCheckedChange = {
            onAddToCartClick()
        },
        enabled = true
    ) {
        Icon(
            imageVector = if (checkedStatus) Icons.Filled.ShoppingCart else Icons.Outlined.ShoppingCart,
            contentDescription = "Favorite",
            tint = if (checkedStatus) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.onBackground
        )
    }
}

@Composable
fun AddToFavouritesButton(
    checkedStatus: Boolean,
    onAddToFavoritesClick: () -> Unit
) {
    IconToggleButton(
        checked = checkedStatus,
        onCheckedChange = {
            onAddToFavoritesClick()
        },
        enabled = true
    ) {
        Icon(
            imageVector = if (checkedStatus) Icons.Filled.ThumbUp else Icons.Outlined.ThumbUp,
            contentDescription = "Favorite",
            tint = if (checkedStatus) MaterialTheme.colorScheme.onSecondary else MaterialTheme.colorScheme.onBackground
        )
    }
}
