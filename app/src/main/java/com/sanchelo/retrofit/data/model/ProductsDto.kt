package com.sanchelo.retrofit.data.model

data class ProductsDto(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)