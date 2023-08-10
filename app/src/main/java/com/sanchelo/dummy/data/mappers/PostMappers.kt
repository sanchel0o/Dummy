package com.sanchelo.dummy.data.mappers

import com.sanchelo.dummy.data.model.remote.PostDto
import com.sanchelo.dummy.domain.model.PostData

fun PostDto.toPostData (): PostData = PostData(
    userId = userId,
    title = title,
    body = body,
    reactions = reactions,
    tags = tags.map {"#${it}"}
)
