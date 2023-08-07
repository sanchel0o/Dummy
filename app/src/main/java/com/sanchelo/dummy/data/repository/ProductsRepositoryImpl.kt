package com.sanchelo.dummy.data.repository

import com.sanchelo.dummy.data.api.ProductsAPI
import com.sanchelo.dummy.data.mappers.toProductDataList
import com.sanchelo.dummy.domain.model.ProductData
import com.sanchelo.dummy.domain.repository.ProductsRepository
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val api: ProductsAPI // if we have "Inject constructor" we don't need a provide func of it
) : ProductsRepository {

    override suspend fun getProductsData(): List<ProductData> =
        api.getAllProducts().toProductDataList()
}
