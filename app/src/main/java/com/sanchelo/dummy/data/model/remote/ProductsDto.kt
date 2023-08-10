package com.sanchelo.dummy.data.model.remote

data class ProductsDto(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)