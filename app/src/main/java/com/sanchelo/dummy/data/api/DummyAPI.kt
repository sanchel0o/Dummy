package com.sanchelo.dummy.data.api

import com.sanchelo.dummy.data.model.remote.PostDto
import com.sanchelo.dummy.data.model.remote.ProductsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface DummyAPI{
    @GET("/products")
    suspend fun getAllProducts(): ProductsDto

    @GET("/posts/{user}")
    suspend fun getPost(@Path("user") user: String): PostDto
}


