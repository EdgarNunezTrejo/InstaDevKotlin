package com.eddev.instadev.view.auth.login

import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eddev.instadev.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(val login: LoginUseCase) : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    private fun isEmailValid(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()
    private fun isPasswordValid(password: String): Boolean = password.length >= 6


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

    fun onClickSelected(){
        viewModelScope.launch (Dispatchers.IO) {
            login(user = _uiState.value.email, password = _uiState.value.password)
        }
    }


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