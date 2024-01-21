package com.example.baseapplication.common.base

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.baseapplication.common.base.navigation.Navigation
import com.example.baseapplication.common.components.dialog.ProgressDialog
import com.example.baseapplication.common.utils.extension.ui.changeBottomMenuVisible
import com.example.baseapplication.common.utils.extension.ui.launchRepeatWithViewLifecycle
import kotlinx.coroutines.launch

abstract class BaseFragment<NAV : Navigation, out VM : BaseViewModel>(
    @LayoutRes resId: Int
) : Fragment(resId) {

    abstract val navigator: NAV
    abstract val viewModel: VM

    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigator.bind(findNavController())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressDialog = ProgressDialog(requireContext())
        initObserve()
        changeBottomMenuVisible(true)
        initBinding()
    }

    private fun initObserve() = with(viewModel) {
        launchRepeatWithViewLifecycle {
            launch {
                showMessage.collect {
                    it.peekContent().showMessage(this@BaseFragment)
                }
            }
            launch {
                progress.collect {
                    progressDialog.show(it)
                }
            }
        }
    }

    abstract fun initBinding()

    override fun onResume() {
        super.onResume()
        fragmentNameFinder()
    }

    private fun fragmentNameFinder() = Log.d(
        "currentFragment",
        "currentFragment: ${this::class.java.simpleName}\n" + "currentFragmentPackage: ${this::class.java}"
    )


    override fun onDestroy() {
        super.onDestroy()
    }
}