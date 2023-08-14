package com.sanchelo.dummy.data.mappers

import com.sanchelo.dummy.data.model.remote.UserDto
import com.sanchelo.dummy.domain.model.UserData

fun UserDto.toUserData(): UserData = UserData(
    email = email,
    firstName = firstName,
    gender = gender,
    id = id,
    image = image,
    lastName = lastName,
    token = token,
    username = username
)