package com.sanchelo.dummy.data.api

import com.sanchelo.dummy.auth.AuthRequest
import com.sanchelo.dummy.data.model.remote.PostDto
import com.sanchelo.dummy.data.model.remote.ProductsDto
import com.sanchelo.dummy.data.model.remote.UserDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface DummyAPI{
    @GET("/products")
    suspend fun getAllProducts(): ProductsDto

    @GET("/posts/{user}")
    suspend fun getPost(@Path("user") user: String): PostDto

    @POST("/auth/login")
    suspend fun authRequest(@Body authRequest: AuthRequest): UserDto
}
