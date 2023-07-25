package com.sanchelo.retrofit.data.mappers

import com.sanchelo.retrofit.data.model.ProductDto
import com.sanchelo.retrofit.domain.model.ProductData

fun ProductDto.toSingleProductData(): ProductData = ProductData(
    id = id,
    title = title,
    category = category,
    brand = brand,
    description = description,
    price = price,
    images = images
)

fun List<ProductDto>.toProductsData(): List<ProductData> = this
    .map { it.toSingleProductData() }


