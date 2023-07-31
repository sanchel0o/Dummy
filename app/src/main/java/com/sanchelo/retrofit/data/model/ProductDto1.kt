package com.sanchelo.retrofit.data.model

data class ProductDto1(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)