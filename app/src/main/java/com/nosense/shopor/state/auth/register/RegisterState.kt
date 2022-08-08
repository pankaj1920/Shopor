package com.nosense.shopor.state.auth.register

import com.nosense.shopor.model.response.register.RegisterResponse

sealed class RegisterState {
    object Init : RegisterState()
    object NavigateToLogin : RegisterState()
    data class SHOW_ERROR(val errorMessage: String) : RegisterState()
    class SHOW_SUCCESS(val response: RegisterResponse):RegisterState()
}