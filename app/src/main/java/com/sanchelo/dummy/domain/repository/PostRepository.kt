package com.sanchelo.dummy.domain.repository

import com.sanchelo.dummy.domain.model.PostData

interface PostRepository {
    suspend fun getPost(): PostData
}