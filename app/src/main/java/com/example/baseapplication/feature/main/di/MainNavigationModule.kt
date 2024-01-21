package com.example.baseapplication.feature.main.di

import com.example.baseapplication.feature.main.navigator.MainNavigation
import com.example.baseapplication.feature.main.navigator.MainNavigationImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainNavigationModule {
    @Provides
    @Singleton
    fun mainNavigationService(): MainNavigation = MainNavigationImpl()
}