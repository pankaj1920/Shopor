package com.nosense.shopor.views.fragment.launcher.launcher

import androidx.fragment.app.viewModels
import com.nosense.shopor.databinding.FragmentLauncherBinding
import com.nosense.shopor.state.splash.launcher.LauncherState
import com.nosense.shopor.viewmodel.splash.launcher.LauncherViewModel
import com.payments.appbase.view_base.BaseFragment


class LauncherFragment(override val layoutId: Int) :
    BaseFragment<LauncherViewModel, FragmentLauncherBinding>() {

    override val mViewModel: LauncherViewModel by viewModels()

    override fun onFragmentCreated() {

    }

    override fun subscribeObservers() {
        mViewModel.stateObserver.observe(this){
            when(it){
                LauncherState.Navigate -> {

                }
            }
        }
    }


}