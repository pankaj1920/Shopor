package com.nosense.shopor.viewmodel.splash.wlcm

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.nosense.shopor.state.splash.wlcm.WelcomeSate
import com.nosense.shopor.utlis.Constant
import com.payments.appbase.viewmodel_base.BaseViewModel

class WelcomeViewModel : BaseViewModel<WelcomeSate>() {

    private var welcomeSate: WelcomeSate = WelcomeSate.Init
        set(value) {
            field = value
            publishState(welcomeSate)
        }

    override fun onInitialized(bundle: Bundle?) {
        Handler(Looper.getMainLooper()).postDelayed({
            welcomeSate = WelcomeSate.NavigateToLogin
        }, Constant.HandlerTime.welcomeTime)
    }
}