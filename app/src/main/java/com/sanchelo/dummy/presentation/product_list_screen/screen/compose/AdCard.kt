package com.sanchelo.dummy.presentation.product_list_screen.screen.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun AdCard(
    imageUrl: String
) {
    Column {
        Text (text = "For you")
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            elevation = CardDefaults.cardElevation(5.dp),
            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surface),
            shape = RoundedCornerShape(5.dp)
        ) {
            AdImage(imageUrl)
        }
    }
}

@Composable
fun AdImage(imageUrl: String) {
    AsyncImage(
        modifier = Modifier.size(500.dp),
        contentScale = ContentScale.Fit,
        model = "https://i.dummyjson.com/data/products/1/thumbnail.jpg",
        contentDescription = "Ad Image")
}