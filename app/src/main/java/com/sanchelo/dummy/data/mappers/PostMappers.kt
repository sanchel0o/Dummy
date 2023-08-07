package com.sanchelo.dummy.data.mappers

import androidx.compose.ui.text.capitalize
import com.sanchelo.dummy.data.model.PostDto
import com.sanchelo.dummy.domain.model.PostData

fun PostDto.toPostData (): PostData = PostData(
    userId = userId,
    title = title,
    body = body,
    reactions = reactions,
    tags = tags
)
