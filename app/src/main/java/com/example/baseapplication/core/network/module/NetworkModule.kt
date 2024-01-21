package com.example.baseapplication.core.network.module

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.baseapplication.BuildConfig
import com.example.baseapplication.common.utils.AppConstants
import com.example.baseapplication.common.utils.qualifier.ApiOkHttpClient
import com.example.baseapplication.core.network.interceptors.prettyJson.PrettyJsonLogger
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideDefaultGson(): Gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS")
        .setLenient().create()

    @Provides
    fun provideGsonConverterFactory(gson: Gson): retrofit2.Converter.Factory {
        return GsonConverterFactory.create(gson)
    }


    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor(PrettyJsonLogger()).apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }

    @Provides
    @ApiOkHttpClient
    fun provideOkHttpClient(
        @ApplicationContext context: Context,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient = OkHttpClient().newBuilder().apply {
        connectTimeout(AppConstants.APP_TIME_OUT_SEC, TimeUnit.SECONDS)
        writeTimeout(AppConstants.APP_TIME_OUT_SEC, TimeUnit.SECONDS)
        readTimeout(AppConstants.APP_TIME_OUT_SEC, TimeUnit.SECONDS)
        addInterceptor(
            ChuckerInterceptor.Builder(context).collector(ChuckerCollector(context))
                .maxContentLength(AppConstants.CHUCKER_MAX_LENGTH).redactHeaders(emptySet())
                .alwaysReadResponseBody(false)
                .build()
        )
        addInterceptor(httpLoggingInterceptor)
        followSslRedirects(false)
        followRedirects(false)
    }.build()
}

