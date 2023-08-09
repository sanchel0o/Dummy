package com.sanchelo.dummy.presentation.main_screen.screen.compose

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
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun PostCard(
    reactions: Int,
    body: String,
    title: String,
    tags: List<String>,
    onLikeClick: () -> Unit,
    checkedStatus: Boolean
) {
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
            PostTitle(title)
            PostBody(body)
            Divider(color = MaterialTheme.colorScheme.background)
            PostInfo(reactions, tags, onLikeClick, checkedStatus)
        }
    }
}

@Composable
fun UserInfo(userImage: String) {
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
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
                text = "Sheldon" + " " + "Quigley"
            )
            Text(
                modifier = Modifier,
                style = TextStyle(
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 15.sp,
                ),
                text = "@username"
            )
        }

    }

}

@Composable
fun PostTitle(title: String) {
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
        text = title
    )
}

@Composable
fun PostBody(body: String) {
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
        text = body
    )
}

@Composable
fun PostInfo(reactions: Int, tags: List<String>, onLikeClick: () -> Unit, checkedStatus: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Tags(tags)
        Reactions(reactions, onLikeClick, checkedStatus)

    }
}

@Composable
fun Tags(tags: List<String>) {
    Row(
    ) {
        tags.forEach {
            TextButton(
                onClick = { /*TODO*/ }
            ) {
                Text(
                    modifier = Modifier,
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.primaryContainer,
                        fontWeight = FontWeight.Light
                    ),
                    text = it
                )
            }
        }
    }

}

@Composable
fun Reactions(
    reactions: Int,
    onLikeClick: () -> Unit,
    checkedStatus: Boolean
) {
    val checked = remember { mutableStateOf(checkedStatus) }
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconToggleButton(
            checked = checkedStatus,
            onCheckedChange = {
                checked.value = it
                onLikeClick()
            },
            enabled = true
        ) {
            if (checked.value) {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.primary
                )
            } else {
                Icon(
                    Icons.Outlined.FavoriteBorder,
                    contentDescription = "",
                )
            }
        }
        Text(text = reactions.toString())
    }
}
