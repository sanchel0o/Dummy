package com.sanchelo.dummy.presentation.product_list_screen.screen.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import org.w3c.dom.Text

@Composable
@Preview(showBackground = true)
fun PostCard() {
    Card(
        modifier = Modifier
            .padding(5.dp)
            .height(300.dp)
            .fillMaxWidth()
            .clickable { },
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.tertiary),
    ) {
        Column(
           // modifier = Modifier.padding(5.dp)
        ) {
            UserInfo(userImage = "")
            PostTitle()
            PostBody()
            Divider()
            PostInfo()
        }
    }
}

@Composable
fun UserInfo(userImage: String) {
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically
    ){
        AsyncImage(
            modifier = Modifier
                .padding(10.dp)
                .size(75.dp)
                .clip(shape = RoundedCornerShape(50.dp))
                .background(MaterialTheme.colorScheme.background),
            model = "https://robohash.org/doloremquesintcorrupti.png",
            contentDescription = "user image"
        )
        Column(
            modifier = Modifier
                .size(150.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium
                ),
                text = "Sheldon" + " " + "Quigley")
            Text(
                modifier = Modifier,
                style = TextStyle(
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 15.sp,
                ),
                text = "@username")
        }

    }

}

@Composable
fun PostTitle() {
    Text(
        modifier = Modifier.padding(start = 10.dp),
        overflow = TextOverflow.Ellipsis,
        maxLines = 1,
        style = TextStyle(
            color = MaterialTheme.colorScheme.onTertiary,
            fontSize = 20.sp,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.SemiBold,
        ),
        text = "He was an expert but not in a discipline"
    )
}

@Composable
fun PostBody() {
    Text(
        modifier = Modifier.padding(start = 10.dp, top = 5.dp, end = 10.dp, bottom = 5.dp),
        overflow = TextOverflow.Ellipsis,
        softWrap = true,
        maxLines = 3,
        style = TextStyle(
            color = MaterialTheme.colorScheme.primaryContainer,
            fontWeight = FontWeight.Light,
            fontSize = 15.sp,
            textAlign = TextAlign.Justify,
        ),
        text = "birthright, & there is nothing in my early life that suggests artistick aptitude or even interest, my pastimes & fascinations nearly all being what may – & were – deemed the merely villainous.\",",
    )
}

@Composable
fun PostInfo() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier,
            style = TextStyle(
                color = MaterialTheme.colorScheme.primaryContainer,
                fontWeight = FontWeight.Light
            ),
            text = "#tags"
        )
        IconButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Outlined.FavoriteBorder, contentDescription = "")
        }
    }
}
