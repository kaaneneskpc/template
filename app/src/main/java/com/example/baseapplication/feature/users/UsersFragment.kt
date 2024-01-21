package com.example.baseapplication.feature.users

import androidx.fragment.app.viewModels
import com.example.baseapplication.R
import com.example.baseapplication.common.base.BaseFragment
import com.example.baseapplication.common.utils.extension.ui.viewBinding
import com.example.baseapplication.databinding.FragmentUsersBinding
import com.example.baseapplication.feature.main.MainViewModel
import com.example.baseapplication.feature.main.navigator.MainNavigation
import com.example.baseapplication.feature.main.navigator.MainNavigationImpl
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class UsersFragment : BaseFragment<MainNavigation, MainViewModel>(R.layout.fragment_users) {

    override val viewModel: MainViewModel by viewModels()

    private val binding by viewBinding(FragmentUsersBinding::bind)

    // todo hilt
    override val navigator: MainNavigation = MainNavigationImpl()

    override fun initBinding() = with(binding) {
    }
}