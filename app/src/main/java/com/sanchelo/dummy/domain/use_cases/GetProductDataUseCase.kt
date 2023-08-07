package com.sanchelo.dummy.domain.use_cases

import com.sanchelo.dummy.domain.model.ProductData
import com.sanchelo.dummy.domain.repository.ProductsRepository
import javax.inject.Inject

interface GetProductDataUseCase {
    suspend fun invoke(): List<ProductData>
}

class GetProductDataUseCaseImpl @Inject constructor(
    private val repository: ProductsRepository
): GetProductDataUseCase {
    override suspend fun invoke(): List<ProductData> = repository.getProductsData()

}