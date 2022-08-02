package com.nosense.shopor.views.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil.setContentView
import androidx.navigation.NavHost
import androidx.navigation.fragment.NavHostFragment
import com.nosense.shopor.R
import com.nosense.shopor.databinding.ActivityMainBinding
import com.nosense.shopor.viewmodel.activity.MainActivityViewModel
import com.payments.appbase.view_base.BaseActivity
import com.payments.appbase.viewmodel_base.BaseViewModel

class MainActivity(override val layoutId: Int = R.layout.activity_main) :
    BaseActivity<MainActivityViewModel, ActivityMainBinding>() {

    override val mViewModel: MainActivityViewModel by viewModels()

    override fun onInitialize() {
        val mainNavHostFragment =
            supportFragmentManager.findFragmentById(R.id.mainNavHost) as NavHostFragment
        val navController = mainNavHostFragment.navController
    }

    override fun subscribeObserver() {

    }

}