package com.eddev.instadev.view.auth

import android.util.Patterns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState

    fun onEmailChange(email: String) {
        _uiState.update { state ->
            state.copy(
                email = email,
                isLoginEnabled = isEmailValid(email = state.email) && isPasswordValid(
                    password = state.password
                )
            )
        }
    }

    fun onPasswordChange(password: String) {
        _uiState.update { state ->
            state.copy(
                password = password,
                isLoginEnabled = isEmailValid(email = state.email) && isPasswordValid(
                    password = state.password
                )
            )
        }
    }

    fun isEmailValid(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()

    fun isPasswordValid(password: String): Boolean = password.length >= 6
}

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isLoginEnabled: Boolean = false,
)


// se pueden usar para vistas complejas
//  sealed class MyUiState {
//      object Error
//        data class Success(val test: String)
//  }