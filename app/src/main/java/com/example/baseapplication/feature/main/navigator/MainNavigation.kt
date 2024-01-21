package com.example.baseapplication.feature.main.navigator

import android.os.Bundle
import com.example.baseapplication.common.base.navigation.Navigation

interface MainNavigation : Navigation {
    fun navigateToX(args: Bundle? = null) //fixme rename funcs
}
