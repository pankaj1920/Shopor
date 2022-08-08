package com.payments.appbase.view_base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.annotation.RawRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.payments.appbase.R
import com.payments.appbase.databinding.ErrorLayoutBinding
import com.payments.appbase.listner_base.BaseRepoListener
import com.payments.appbase.utils_base.*
import com.payments.appbase.utils_base.session.SessionManager
import com.payments.appbase.viewmodel_base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

abstract class BaseFragment<VM : BaseViewModel<*>, VB : ViewDataBinding> : Fragment(),
    BaseRepoListener {

    protected abstract val mViewModel: BaseViewModel<*>

    @get:LayoutRes
    abstract val layoutId: Int

    abstract fun onFragmentCreated()

    abstract fun subscribeObservers()

    lateinit var mViewBinding: VB

    lateinit var iBaseRepoListener: BaseRepoListener

    private val progressBar: CustomProgressBar by lazy {
        CustomProgressBar()
    }

    val sessionManager: SessionManager by lazy {
        SessionManager(requireContext())
    }

    private val codeSnippet: CodeSnippet by lazy {
        CodeSnippet(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (::mViewBinding.isInitialized.not()) {
            mViewBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
            mViewBinding.lifecycleOwner = viewLifecycleOwner
        }
        return mViewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch(Dispatchers.Main) {
            async { subscribeObservers() }.await()

            iBaseRepoListener = this@BaseFragment

            mViewModel.onInitialized(arguments)

            onFragmentCreated()

            initLoader()
        }
    }

    private fun initLoader() {
        mViewModel.baseLiveData.observe(viewLifecycleOwner) {
            when (it.first) {
                BaseConstants.BaseKeys.SHOW_LOADER -> showLoader()
                BaseConstants.BaseKeys.SHOW_LOADER_MESSAGE -> showMessage(it.second as String)
                BaseConstants.BaseKeys.HIDE_LOADER -> hideLoader()
                BaseConstants.BaseKeys.SHOW_MESSAGE -> showMessage(it.second as String)
            }
        }
    }


    override fun showLoader() {
        showProgressBar(progressBar)
    }

    override fun hideLoader() {
        dismissProgressBar(progressBar)
    }

    override fun showMessage(message: String) {
        toastMessage(message)
    }

    override fun isNetworkConnected(): Boolean {
        val isConnected = NetworkConnection(requireContext()).hasNetworkConnection()
        if (isConnected.not()) {
            showMessage(getString(R.string.not_internet_connection))
            Print.log(getString(R.string.not_internet_connection))
        }
        return isConnected
    }

    override fun showErrorMessage(message: String) {
        Print.log("Error Message => $message")
        showBottomDialog(message)
    }

}