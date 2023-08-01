package com.sanchelo.retrofit.data.repository

import com.sanchelo.retrofit.data.api.ProductsAPI
import com.sanchelo.retrofit.data.mappers.toProductDataList
import com.sanchelo.retrofit.domain.model.ProductData
import com.sanchelo.retrofit.domain.repository.ProductsRepository
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val api: ProductsAPI // if we have "Inject constructor" we don't need a provide func of it
) : ProductsRepository {

    override suspend fun getProductsData(): List<ProductData> =
        api.getAllProducts().toProductDataList()
}
