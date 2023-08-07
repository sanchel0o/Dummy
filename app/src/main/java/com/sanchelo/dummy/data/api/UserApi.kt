package com.sanchelo.dummy.data.api

import com.sanchelo.dummy.data.model.UserDto
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {

    @GET("users/{id}")
    suspend fun GetUserById(@Path("id") id: String): UserDto
}