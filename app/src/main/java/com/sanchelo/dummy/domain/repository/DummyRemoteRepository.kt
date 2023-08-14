package com.sanchelo.dummy.domain.repository

import com.sanchelo.dummy.auth.AuthRequest
import com.sanchelo.dummy.domain.model.PostData
import com.sanchelo.dummy.domain.model.ProductData
import com.sanchelo.dummy.domain.model.UserData

interface DummyRemoteRepository {
    suspend fun getProductsData(): List<ProductData>
    suspend fun getPost(): PostData
    suspend fun authRequest(): UserData
}