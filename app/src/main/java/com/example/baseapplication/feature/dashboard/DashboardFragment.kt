package com.example.baseapplication.feature.dashboard

import androidx.fragment.app.viewModels
import com.example.baseapplication.R
import com.example.baseapplication.common.base.BaseFragment
import com.example.baseapplication.common.utils.extension.ui.viewBinding
import com.example.baseapplication.databinding.FragmentDashboardBinding
import com.example.baseapplication.feature.main.navigator.MainNavigation
import com.example.baseapplication.feature.main.navigator.MainNavigationImpl
import com.example.baseapplication.feature.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DashboardFragment : BaseFragment<MainNavigation, MainViewModel>(R.layout.fragment_dashboard) {

    override val viewModel: MainViewModel by viewModels()

    private val binding by viewBinding(FragmentDashboardBinding::bind)

    // todo hilt
    override val navigator: MainNavigation = MainNavigationImpl()

    override fun initBinding() {
        viewModel.startApi()
        binding.testText.setOnClickListener {
            navigator.navigateToX()
        }
    }
}