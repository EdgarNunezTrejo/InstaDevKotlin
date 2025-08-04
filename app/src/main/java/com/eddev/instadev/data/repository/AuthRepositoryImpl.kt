package com.eddev.instadev.data.repository

import com.eddev.instadev.data.response.UserResponse
import com.eddev.instadev.data.response.toDomain
import com.eddev.instadev.domain.entity.UserEntity
import com.eddev.instadev.domain.repositories.AuthRepository
import javax.sql.DataSource

class AuthRepositoryImpl(): AuthRepository {
    override fun doLogin(user: String, password: String):UserEntity{
        val userResponse: UserResponse = UserResponse("","","", 10, listOf(""), 0)
        return userResponse.toDomain()
    }
}