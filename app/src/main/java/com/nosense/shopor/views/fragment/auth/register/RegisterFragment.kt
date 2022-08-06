package com.nosense.shopor.views.fragment.auth.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nosense.shopor.R
import com.nosense.shopor.databinding.FragmentRegisterBinding
import com.nosense.shopor.state.auth.register.RegisterState
import com.nosense.shopor.viewmodel.auth.RegisterViewModel
import com.payments.appbase.utils_base.Toaster
import com.payments.appbase.utils_base.navigateTo
import com.payments.appbase.utils_base.toastMessage
import com.payments.appbase.view_base.BaseFragment
import com.payments.appbase.viewmodel_base.BaseViewModel


class RegisterFragment : BaseFragment<RegisterViewModel, FragmentRegisterBinding>() {

    override val mViewModel: RegisterViewModel by viewModels()
    override val layoutId: Int = R.layout.fragment_register

    override fun onFragmentCreated() {
        mViewBinding.clickListner = this
        mViewBinding.viewModel = mViewModel

    }

    override fun subscribeObservers() {
        mViewModel.stateObserver.observe(this) {
            when (it) {
                is RegisterState.NavigateToLogin -> {
                    findNavController().navigateTo(R.id.loginFragment)
                }
                is RegisterState.SHOW_ERROR -> {
                    toastMessage(it.errorMessage)
                }
            }
        }
    }


    fun onSignUpClicked(view: View) {
        mViewModel.register(baseRepoListener = iBaseRepoListener)
    }

    fun onLoginClicked(view: View) {
        mViewModel.navigateToLogin()
    }

}