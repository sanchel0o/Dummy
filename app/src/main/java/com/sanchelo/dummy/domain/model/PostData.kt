package com.sanchelo.dummy.domain.model

data class PostData(
    val body: String,
    val reactions: Int,
    val tags: List<String>,
    val title: String,
    val userId: Int
)
