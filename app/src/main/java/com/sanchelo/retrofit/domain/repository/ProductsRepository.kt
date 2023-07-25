package com.sanchelo.retrofit.domain.repository

import com.sanchelo.retrofit.domain.model.ProductData

interface ProductsRepository {
    suspend fun getProductsData(): List<ProductData>
}