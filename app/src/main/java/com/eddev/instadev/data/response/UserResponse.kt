package com.eddev.instadev.data.response

import com.eddev.instadev.domain.entity.UserEntity
import com.eddev.instadev.domain.entity.UserMode.*

data class UserResponse(
    val userID: String,
    val name: String,
    val nickname: String,
    val followers: Int,
    val following: List<String>,
    val userType: Int
)

fun UserResponse.toDomain(): UserEntity {
    val userMode = when (userType) {
        REGULAR_USER.userType -> REGULAR_USER
        CONTENT_CREATOR_USER.userType -> CONTENT_CREATOR_USER
        COMPANY_USER.userType -> COMPANY_USER
        else -> REGULAR_USER
    }
    return UserEntity(
        userID = userID,
        name = name,
        nickname = nickname,
        followers = followers,
        following = following,
        userMode = userMode
    )
}