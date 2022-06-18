package com.lee989898.soptlee.di

import android.content.SharedPreferences
import com.lee989898.soptlee.data.local.datasource.LocalTokenDataSource
import com.lee989898.soptlee.data.local.datasourceimpl.LocalTokenDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataSourceModule {

    @Provides
    @Singleton
    fun provideLocalTokenDataSource(localPreferences: SharedPreferences): LocalTokenDataSource =
        LocalTokenDataSourceImpl(localPreferences)

}