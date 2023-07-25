package com.sanchelo.retrofit.data.api

import com.sanchelo.retrofit.data.model.ProductDto
import retrofit2.http.GET

interface ProductsAPI{
    @GET("/products")
    suspend fun getAllProducts(): List<ProductDto>
}


