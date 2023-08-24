package com.sanchelo.dummy.data.repository

import com.sanchelo.dummy.auth.AuthRequest
import com.sanchelo.dummy.data.api.DummyAPI
import com.sanchelo.dummy.data.mappers.toPostData
import com.sanchelo.dummy.data.mappers.toProductDataList
import com.sanchelo.dummy.data.mappers.toUserData
import com.sanchelo.dummy.domain.model.PostData
import com.sanchelo.dummy.domain.model.ProductData
import com.sanchelo.dummy.domain.model.UserData
import com.sanchelo.dummy.domain.repository.DummyRemoteRepository
import javax.inject.Inject
import kotlin.random.Random

class DummyRemoteRepositoryImpl @Inject constructor(
    private val api: DummyAPI, // if we have "Inject constructor" we don't need a provide func of it
) : DummyRemoteRepository {

    override suspend fun getProductsData(): List<ProductData> =
        api.getAllProducts().toProductDataList()

    override suspend fun getPost(): PostData {
        val id = Random.nextInt(1, 50).toString()
        return api.getPost(id).toPostData()
    }

    override suspend fun authRequest(username: String, password: String): UserData {
        return api.authRequest(AuthRequest(username,password)).toUserData()
    }

}
