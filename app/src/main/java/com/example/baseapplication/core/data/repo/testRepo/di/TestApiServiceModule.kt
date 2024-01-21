package com.example.baseapplication.core.data.repo.testRepo.di

import com.example.baseapplication.core.data.repo.testRepo.services.TestServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object TestApiServiceModule {

    @Provides
    fun provideTestService(retrofit: Retrofit): TestServices =
        retrofit.create(TestServices::class.java)
}
