package com.lee989898.soptlee.data.local.datasourceimpl

import android.content.SharedPreferences
import com.lee989898.soptlee.data.local.datasource.LocalTokenDataSource
import javax.inject.Inject

class LocalTokenDataSourceImpl @Inject constructor(
    private val localPreferences: SharedPreferences
) : LocalTokenDataSource {

    override fun getAccessToken() =
        localPreferences.getString(ACCESS_TOKEN, DEFAULT_STRING_VALUE) ?: DEFAULT_STRING_VALUE

    companion object {
        private const val ACCESS_TOKEN = "ACCESS_TOKEN"
        const val DEFAULT_STRING_VALUE = ""
    }
}