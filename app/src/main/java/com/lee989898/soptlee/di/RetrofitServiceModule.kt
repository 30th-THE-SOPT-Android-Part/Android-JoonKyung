package com.lee989898.soptlee.di

import com.lee989898.soptlee.data.remote.api.AuthService
import com.lee989898.soptlee.data.remote.api.GithubService

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitServiceModule {

    @Provides
    @Singleton
    fun provideAuthService(@Named("Normal") retrofit: Retrofit): AuthService =
        retrofit.create(AuthService::class.java)

    @Provides
    @Singleton
    fun provideGithubService(@Named("Email") retrofit: Retrofit): GithubService =
        retrofit.create(GithubService::class.java)
}