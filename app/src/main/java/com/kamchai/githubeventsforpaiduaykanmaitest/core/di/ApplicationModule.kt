package com.kamchai.githubeventsforpaiduaykanmaitest.core.di

import android.content.Context
import com.google.gson.GsonBuilder
import com.kamchai.githubeventsforpaiduaykanmaitest.core.SERVER_ENDPOINT
import com.kamchai.githubeventsforpaiduaykanmaitest.core.SERVER_TIMEOUT_SECONDS
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import com.kamchai.githubeventsforpaiduaykanmaitest.core.base.service.ApiService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    @Singleton
    fun provideApiService(client: OkHttpClient): ApiService =
        Retrofit.Builder().baseUrl(SERVER_ENDPOINT)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().serializeNulls().create()
                )
            )
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()
            .create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideOkHttpClient() = OkHttpClient.Builder()
        .readTimeout(SERVER_TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
        .connectTimeout(SERVER_TIMEOUT_SECONDS.toLong(), TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }).retryOnConnectionFailure(true)
        .build()

}