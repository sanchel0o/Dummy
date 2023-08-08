package com.sanchelo.dummy.data.repository

import com.sanchelo.dummy.data.api.ProductsAPI
import com.sanchelo.dummy.data.mappers.toPostData
import com.sanchelo.dummy.data.mappers.toProductDataList
import com.sanchelo.dummy.domain.model.PostData
import com.sanchelo.dummy.domain.model.ProductData
import com.sanchelo.dummy.domain.repository.ProductsRepository
import javax.inject.Inject
import kotlin.random.Random

class ProductsRepositoryImpl @Inject constructor(
    private val api: ProductsAPI, // if we have "Inject constructor" we don't need a provide func of it
) : ProductsRepository {

    override suspend fun getProductsData(): List<ProductData> =
        api.getAllProducts().toProductDataList()

    override suspend fun getPost(): PostData {
        val id = Random.nextInt(1, 50).toString()
        return api.getPost(id).toPostData()
    }
}
