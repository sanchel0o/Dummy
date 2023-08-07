package com.sanchelo.dummy.data.api

import com.sanchelo.dummy.data.model.PostDto
import retrofit2.http.GET
import retrofit2.http.Path

interface PostAPI {
    @GET("/posts/{user}")
    suspend fun getPost(@Path("user") user: String): PostDto
}