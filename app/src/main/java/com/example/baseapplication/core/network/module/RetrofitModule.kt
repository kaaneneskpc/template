package com.example.baseapplication.core.network.module

import com.example.baseapplication.BuildConfig
import com.example.baseapplication.common.utils.qualifier.ApiOkHttpClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun provideServiceApiRetrofit(
        @ApiOkHttpClient okHttpClient: OkHttpClient,
        converterFactory : Converter.Factory
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(converterFactory).client(okHttpClient).build()
}
