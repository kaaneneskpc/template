package com.example.baseapplication.common.utils.extension.ui

import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.baseapplication.R
import com.google.android.material.bottomnavigation.BottomNavigationView

fun BottomNavigationView.init(navController: NavController) {
    setupWithNavController(navController)
    setOnItemSelectedListener { item ->
        // farklı item
        NavigationUI.onNavDestinationSelected(item, navController)
        if (navController.backQueue.size > 1) {
            navController.popBackStack(destinationId = item.itemId, inclusive = false)
        }
        true
    }
    setOnItemReselectedListener {
        // ayni iteme aynı sayfada
        navController.popBackStack(destinationId = it.itemId, inclusive = false)
    }
}

fun BottomNavigationView.setVisible(visible: Boolean) {
    if (isVisible == visible) return
    isVisible = visible
}