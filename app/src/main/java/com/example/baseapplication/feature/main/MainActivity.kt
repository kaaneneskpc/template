package com.example.baseapplication.feature.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.baseapplication.R
import com.example.baseapplication.common.utils.extension.kotlin.then
import com.example.baseapplication.common.utils.extension.ui.init
import com.example.baseapplication.common.utils.extension.ui.setVisible
import com.example.baseapplication.databinding.ActivityMainBinding
import com.example.baseapplication.feature.main.navigator.MainNavigation
import com.example.baseapplication.feature.main.navigator.MainNavigationImpl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val viewModel: MainViewModel by viewModels()
    val navigator: MainNavigation = MainNavigationImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpBottomNavCall()
    }

    internal fun setBottomMenuVisible(visible: Boolean) =
        this::binding.isInitialized.then { binding.bottomNavigation.setVisible(visible) }

    private fun setUpBottomNavCall() =
        binding.bottomNavigation.init(findNavController(R.id.nav_host_fragment))
}