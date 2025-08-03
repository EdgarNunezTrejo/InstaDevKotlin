package com.eddev.instadev.view.core.navigation

import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
data class SignUp(val isPhoneMethod: Boolean)

@Serializable
object SignUpEmail