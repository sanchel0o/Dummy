package com.sanchelo.retrofit.data.api

import com.sanchelo.retrofit.data.model.ProductsDto
import retrofit2.http.GET

interface ProductsAPI{
    @GET("/products")
    suspend fun getAllProducts(): ProductsDto
}


