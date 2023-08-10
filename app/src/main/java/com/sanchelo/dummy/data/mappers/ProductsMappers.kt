package com.sanchelo.dummy.data.mappers

import com.sanchelo.dummy.data.model.remote.Product
import com.sanchelo.dummy.data.model.remote.ProductsDto
import com.sanchelo.dummy.domain.model.ProductData

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



