package com.nosense.shopor.state.splash.launcher

sealed class LauncherState {
    object Init : LauncherState()
    object Navigate : LauncherState()
}
