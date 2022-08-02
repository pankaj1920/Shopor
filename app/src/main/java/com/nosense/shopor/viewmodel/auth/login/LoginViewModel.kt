package com.nosense.shopor.viewmodel.auth.login

import android.os.Bundle
import com.nosense.shopor.state.auth.login.LoginState
import com.payments.appbase.viewmodel_base.BaseViewModel

class LoginViewModel : BaseViewModel<LoginState>() {

    var loginState: LoginState = LoginState.Init
        set(value) {
            field = value
            publishState(loginState)
        }

    override fun onInitialized(bundle: Bundle?) {

    }

    fun register(){
        loginState = LoginState.NavigateToRegister
    }

    fun forgotPassword(){
        loginState = LoginState.NavigateToForgotPass
    }
}