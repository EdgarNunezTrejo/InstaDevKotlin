package com.eddev.instadev.view.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.eddev.instadev.view.auth.login.LoginScreen
import com.eddev.instadev.view.auth.signup.SignUpScreen

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Login) {
        composable<Login> {
            LoginScreen(onCreateAccountClick = {navController.navigate(SignUp(isPhoneMethod = true))})
        }

        composable<SignUp> {
            SignUpScreen( onBackClick = {navController.popBackStack()})
        }
    }
}