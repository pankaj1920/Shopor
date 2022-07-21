package com.nosense.shopor.viewmodel.splash.launcher

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.os.postDelayed
import com.nosense.shopor.state.splash.launcher.LauncherState
import com.nosense.shopor.utlis.Constant
import com.payments.appbase.viewmodel_base.BaseViewModel

class LauncherViewModel : BaseViewModel<LauncherState>() {

    private var launcherState: LauncherState = LauncherState.Init
        set(value) {
            field = value
            publishState(launcherState)
        }

    override fun onInitialized(bundle: Bundle?) {
        Handler(Looper.getMainLooper()).postDelayed({
         launcherState =  LauncherState.Navigate
        },Constant.HandlerTime.splashTime)
    }
}