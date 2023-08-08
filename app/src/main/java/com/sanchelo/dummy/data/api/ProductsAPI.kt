package com.sanchelo.dummy.data.api

import com.sanchelo.dummy.data.model.PostDto
import com.sanchelo.dummy.data.model.ProductsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductsAPI{
    @GET("/products")
    suspend fun getAllProducts(): ProductsDto

    @GET("/posts/{user}")
    suspend fun getPost(@Path("user") user: String): PostDto
}


