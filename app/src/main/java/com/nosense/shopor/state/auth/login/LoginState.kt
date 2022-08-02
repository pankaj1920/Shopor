package com.nosense.shopor.state.auth.login

sealed class LoginState {
    object Init : LoginState()
    object NavigateToRegister : LoginState()
    object NavigateToForgotPass : LoginState()
    object NavigateToHome : LoginState()
}