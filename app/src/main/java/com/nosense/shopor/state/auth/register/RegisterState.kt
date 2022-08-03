package com.nosense.shopor.state.auth.register

sealed class RegisterState {
    object Init : RegisterState()
    object NavigateToLogin : RegisterState()
    data class SHOW_ERROR(val errorMessage: String) : RegisterState()
}