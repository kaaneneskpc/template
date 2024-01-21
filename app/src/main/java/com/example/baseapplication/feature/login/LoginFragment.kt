package com.example.baseapplication.feature.login

import androidx.fragment.app.viewModels
import com.example.baseapplication.R
import com.example.baseapplication.common.base.BaseFragment
import com.example.baseapplication.common.utils.extension.ui.changeBottomMenuVisible
import com.example.baseapplication.common.utils.extension.ui.viewBinding
import com.example.baseapplication.databinding.FragmentLoginBinding
import com.example.baseapplication.feature.main.navigator.MainNavigation
import com.example.baseapplication.feature.main.navigator.MainNavigationImpl
import com.example.baseapplication.feature.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginFragment : BaseFragment<MainNavigation, MainViewModel>(R.layout.fragment_login) {

    override val viewModel: MainViewModel by viewModels()

    private val binding by viewBinding(FragmentLoginBinding::bind)

    // todo hilt
    override val navigator: MainNavigation = MainNavigationImpl()

    override fun initBinding() {
        changeBottomMenuVisible(false)
    }
}