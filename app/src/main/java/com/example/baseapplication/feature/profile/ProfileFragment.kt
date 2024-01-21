package com.example.baseapplication.feature.profile

import androidx.fragment.app.viewModels
import com.example.baseapplication.R
import com.example.baseapplication.common.base.BaseFragment
import com.example.baseapplication.common.utils.extension.ui.viewBinding
import com.example.baseapplication.databinding.FragmentProfileBinding
import com.example.baseapplication.feature.main.MainViewModel
import com.example.baseapplication.feature.main.navigator.MainNavigation
import com.example.baseapplication.feature.main.navigator.MainNavigationImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseFragment<MainNavigation, MainViewModel>(R.layout.fragment_profile) {

    override val viewModel: MainViewModel by viewModels()

    private val binding by viewBinding(FragmentProfileBinding::bind)

    override val navigator: MainNavigation = MainNavigationImpl()

    override fun initBinding() = with(binding) {

    }
}