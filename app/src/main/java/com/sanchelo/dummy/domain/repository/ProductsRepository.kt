package com.sanchelo.dummy.domain.repository

import com.sanchelo.dummy.domain.model.ProductData

interface ProductsRepository {
    suspend fun getProductsData(): List<ProductData>
}