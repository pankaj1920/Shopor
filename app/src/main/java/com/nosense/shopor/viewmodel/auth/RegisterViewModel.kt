package com.nosense.shopor.viewmodel.auth

import android.os.Bundle
import com.nosense.shopor.state.auth.register.RegisterState
import com.payments.appbase.viewmodel_base.BaseViewModel

class RegisterViewModel : BaseViewModel<RegisterState>() {

    private var registerState: RegisterState = RegisterState.Init
        set(value) {
            field = value
            publishState(registerState)
        }

    override fun onInitialized(bundle: Bundle?) {

    }

    fun navigateToLogin() {
        registerState = RegisterState.NavigateToLogin
    }
}