package com.example.baseapplication.feature.main.navigator

import android.os.Bundle
import androidx.navigation.navOptions
import com.example.baseapplication.R
import com.example.baseapplication.common.base.navigation.BaseNavigator

class MainNavigationImpl : BaseNavigator(), MainNavigation {
    override fun navigateToX(args: Bundle?) {
        navController.navigate(R.id.loginFragmentWithMain, args)
    }
}