package com.sanchelo.dummy.data.repository

import com.sanchelo.dummy.data.api.PostAPI
import com.sanchelo.dummy.data.mappers.toPostData
import com.sanchelo.dummy.domain.model.PostData
import com.sanchelo.dummy.domain.repository.PostRepository
import javax.inject.Inject
import kotlin.random.Random

class PostRepositoryImpl @Inject constructor(
    private val postAPI: PostAPI
): PostRepository {
    override suspend fun getPost(): PostData {
        val id = Random.nextInt(1, 50).toString()
        return postAPI.getPost(id).toPostData()
    }
}
