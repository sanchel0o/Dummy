package com.sanchelo.retrofit.data.mappers

import com.sanchelo.retrofit.data.model.Product
import com.sanchelo.retrofit.data.model.ProductsDto
import com.sanchelo.retrofit.domain.model.ProductData

fun ProductsDto.toProductDataList(): List<ProductData> = this.products
    .map { it.toProductData() }
fun Product.toProductData(): ProductData = ProductData(
    id = id,
    title = title,
    category = category,
    brand = brand,
    description = description,
    price = price,
    images = images
)



