package com.sanchelo.retrofit.domain.model

data class ProductData(
    val id: Int,
    val title: String,
    val category: String,
    val brand: String,
    val description: String,
    val price: Int,
    val images: List<String>
)
