package com.eddev.instadev.view.auth.signup

import android.util.Patterns
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(SignUpUiState())
    val uiState: StateFlow<SignUpUiState> = _uiState

    fun onChangeMode() {
        _uiState.update{state->
            state.copy(
                isPhoneMode = !state.isPhoneMode,
                value = ""
            )
        }
    }

    fun onValueChange(value: String) {
        _uiState.update { state ->
            state.copy(
                value = value,
                isSignUpEnabled = isValueValid(state.value)
            )
        }
    }

    fun isValueValid(email: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches() || Patterns.PHONE.matcher(email).matches()
}

data class SignUpUiState(
    val value: String = "",
    val isPhoneMode: Boolean = true,
    val isSignUpEnabled: Boolean = false
)

//class SignUpViewModel: ViewModel(){
//    private val _uiSignUpState = MutableStateFlow(SignUpUiState())
//    val uiSignUpState:StateFlow<SignUpUiState>  = _uiSignUpState
//
//    fun onEmailChange(email: String){
//        _uiSignUpState.update { state->
//            state.copy(
//                email = email,
//                isSignUpEnabled = isEmailValid(state.email)
//            )
//        }
//    }
//
//    fun onPhoneChange(phone: String){
//        _uiSignUpState.update { state->
//            state.copy(
//                phone = phone,
//                isSignUpEnabled = isPhoneValid(state.phone)
//            )
//        }
//    }
//
//    fun isEmailValid(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()
//
//    fun isPhoneValid(phone: String): Boolean = Patterns.PHONE.matcher(phone).matches()
//}
//
//data class SignUpUiState(
//    val email: String = "",
//    val phone: String = "",
//    val isLoading: Boolean = false,
//    val isSignUpEnabled: Boolean = false,
//)

