package com.lee989898.soptlee.di

import com.lee989898.soptlee.data.local.datasource.LocalTokenDataSource
import com.lee989898.soptlee.data.remote.datasource.AuthDataSource
import com.lee989898.soptlee.data.remote.datasource.GithubDataSource
import com.lee989898.soptlee.data.remote.repository.AuthRepositoryImpl
import com.lee989898.soptlee.data.remote.repository.GithubRepositoryImpl
import com.lee989898.soptlee.domain.repository.AuthRepository
import com.lee989898.soptlee.domain.repository.GithubRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesAuthRepository(
        authDataSource: AuthDataSource
    ): AuthRepository = AuthRepositoryImpl(authDataSource)

    @Provides
    @Singleton
    fun providesGithubRepository(
        githubDataSource: GithubDataSource
    ): GithubRepository = GithubRepositoryImpl(githubDataSource)

}