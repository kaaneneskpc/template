package com.example.baseapplication.core.data.repo.testRepo.di

import com.example.baseapplication.core.data.repo.testRepo.repo.TestRepository
import com.example.baseapplication.core.data.repo.testRepo.repo.TestRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class TestRepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun bindTestRepository(testRepository: TestRepositoryImpl): TestRepository

}