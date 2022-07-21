package com.payments.appbase.viewmodel_base

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.payments.appbase.utils_base.SingleLiveEvent

abstract class BaseViewModel<S>:ViewModel() {

    abstract fun onInitialized(bundle:Bundle?)

    val baseLiveData = SingleLiveEvent<Pair<String, Any>>()


    val stateObserver:SingleLiveEvent<S> by lazy {
        SingleLiveEvent()
    }

    protected fun publishState(state:S){
        stateObserver.postValue(state)
    }


}