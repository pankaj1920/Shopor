package com.nosense.shopor.views.fragment.launcher.launcher

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nosense.shopor.R
import com.nosense.shopor.databinding.FragmentLauncherBinding
import com.nosense.shopor.state.splash.launcher.LauncherState
import com.nosense.shopor.viewmodel.splash.launcher.LauncherViewModel
import com.payments.appbase.utils_base.navigateNew
import com.payments.appbase.utils_base.navigateTo
import com.payments.appbase.view_base.BaseFragment


class LauncherFragment(override val layoutId: Int = R.layout.fragment_launcher) :
    BaseFragment<LauncherViewModel, FragmentLauncherBinding>() {

    override val mViewModel: LauncherViewModel by viewModels()

    override fun onFragmentCreated() {

    }

    override fun subscribeObservers() {
        mViewModel.stateObserver.observe(this) {
            when (it) {
                LauncherState.Navigate -> {
                    findNavController().navigateNew(
                        R.id.welcomeFragment,
                        R.id.shopor_graph
                    )
                }
            }
        }
    }


}