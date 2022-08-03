package com.nosense.shopor.viewmodel.auth

import android.os.Bundle
import androidx.lifecycle.viewModelScope
import com.nosense.shopor.model.request.register.RegisterRequest
import com.nosense.shopor.model.response.register.RegisterResponse
import com.nosense.shopor.network.ModelRepository
import com.nosense.shopor.state.auth.register.RegisterState
import com.payments.appbase.listner_base.BaseRepoListener
import com.payments.appbase.model_base.State
import com.payments.appbase.utils_base.Print
import com.payments.appbase.viewmodel_base.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class RegisterViewModel : BaseViewModel<RegisterState>() {

    val registerRequestData = RegisterRequest()

    private var registerState: RegisterState = RegisterState.Init
        set(value) {
            field = value
            publishState(registerState)
        }

    override fun onInitialized(bundle: Bundle?) {
    }

    fun register(baseRepoListener: BaseRepoListener) {
        Print.log("Register Request = > ${registerRequestData.email}")

        viewModelScope.launch {
            ModelRepository(baseRepoListener).register(registerRequestData).collect {
                when (it) {
                    is State.Success -> {
                        handleSuccess(it.data)
                    }

                    is State.Error -> {
                        Print.log("Register Error ${it.message}")
                        registerState = RegisterState.SHOW_ERROR(it.message)
                    }
                }
            }
        }

    }

    private fun handleSuccess(response: RegisterResponse) {
        response.message?.let { message ->
            Print.log("Register Success $message")
        }
    }

    fun navigateToLogin() {
        registerState = RegisterState.NavigateToLogin
    }
}