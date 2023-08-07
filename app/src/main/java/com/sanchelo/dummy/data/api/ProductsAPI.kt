package com.sanchelo.dummy.data.api

import com.sanchelo.dummy.data.model.ProductsDto
import retrofit2.http.GET

interface ProductsAPI{
    @GET("/products")
    suspend fun getAllProducts(): ProductsDto
}


