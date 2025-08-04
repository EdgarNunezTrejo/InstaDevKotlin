package com.eddev.instadev.domain.repositories

import com.eddev.instadev.domain.entity.UserEntity

interface AuthRepository {
    fun doLogin(user: String, password: String): UserEntity
}