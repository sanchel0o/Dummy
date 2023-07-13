package com.sanchelo.retrofit.remote

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MainAPI{
    @GET("/products/{id}")
    suspend fun getSingleProductData(@Path("id") id : Int): SingleProductDto

    @POST("/docs/auth")
    suspend fun getUserData(@Body authRequest: AuthRequest): UserDataDto
}


