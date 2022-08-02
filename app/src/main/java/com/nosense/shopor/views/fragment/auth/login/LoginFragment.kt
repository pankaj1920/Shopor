package com.nosense.shopor.views.fragment.auth.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nosense.shopor.R
import com.nosense.shopor.databinding.FragmentLoginBinding
import com.nosense.shopor.state.auth.login.LoginState
import com.nosense.shopor.viewmodel.auth.login.LoginViewModel
import com.payments.appbase.utils_base.Print
import com.payments.appbase.utils_base.navigateTo
import com.payments.appbase.view_base.BaseFragment
import com.payments.appbase.viewmodel_base.BaseViewModel


class LoginFragment(override val layoutId: Int = R.layout.fragment_login) :
    BaseFragment<LoginViewModel, FragmentLoginBinding>() {

    override val mViewModel: LoginViewModel by viewModels()

    override fun onFragmentCreated() {
        mViewBinding.clickListner = this

    }

    override fun subscribeObservers() {
        mViewModel.stateObserver.observe(this) {
            when (it) {
                LoginState.NavigateToRegister -> {
                    findNavController().navigateTo(R.id.registerFragment)
                }

                LoginState.NavigateToForgotPass -> {
                    findNavController().navigateTo(R.id.forgotPasswordFragment)
                }
            }
        }
    }


    fun onSignUpClicked(view: View) {
        mViewModel.register()
    }

    fun onForgotPasswordClicked(view: View) {
        mViewModel.forgotPassword()
    }
}