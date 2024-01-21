package com.example.baseapplication.core.data.cache.di

import android.content.Context
import android.content.SharedPreferences
import com.example.baseapplication.core.data.cache.SharedPrefManager
import com.example.baseapplication.common.utils.AppConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Provides
    @Singleton
    fun provideSharedPrefHandler(sharedPreferences: SharedPreferences): SharedPrefManager {
        return SharedPrefManager(sharedPreferences)
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(AppConstants.SHARED_PREFERENCES, Context.MODE_PRIVATE)
    }

}
