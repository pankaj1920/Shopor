package com.nosense.shopor.state.splash.wlcm

sealed class WelcomeSate{
    object Init:WelcomeSate()
    object NavigateToLogin:WelcomeSate()
}
