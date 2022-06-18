package com.lee989898.soptlee.di

import com.lee989898.soptlee.data.remote.api.AuthService
import com.lee989898.soptlee.data.remote.api.GithubService
import com.lee989898.soptlee.data.remote.datasource.AuthDataSource
import com.lee989898.soptlee.data.remote.datasource.GithubDataSource
import com.lee989898.soptlee.data.remote.datasourceimpl.AuthDataSourceImpl
import com.lee989898.soptlee.data.remote.datasourceimpl.GithubDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataSourceModule {

    @Provides
    @Singleton
    fun provideAuthDataSource(authService: AuthService): AuthDataSource =
        AuthDataSourceImpl(authService)

    @Provides
    @Singleton
    fun provideGithubDataSource(githubService: GithubService): GithubDataSource =
        GithubDataSourceImpl(githubService)

}