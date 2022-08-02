package com.nosense.shopor.views.fragment.launcher.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nosense.shopor.R
import com.nosense.shopor.databinding.FragmentWelcomeBinding
import com.nosense.shopor.state.splash.wlcm.WelcomeSate
import com.nosense.shopor.viewmodel.splash.wlcm.WelcomeViewModel
import com.payments.appbase.utils_base.navigateNew
import com.payments.appbase.view_base.BaseFragment
import com.payments.appbase.viewmodel_base.BaseViewModel


class WelcomeFragment(override val layoutId: Int = R.layout.fragment_welcome) :
    BaseFragment<WelcomeViewModel, FragmentWelcomeBinding>() {

    override val mViewModel: WelcomeViewModel by viewModels()

    override fun onFragmentCreated() {

    }

    override fun subscribeObservers() {
        mViewModel.stateObserver.observe(this) {
            when (it) {
                WelcomeSate.NavigateToLogin -> {
                    findNavController().navigateNew(R.id.loginFragment, R.id.shopor_graph)
                }
            }
        }
    }


}