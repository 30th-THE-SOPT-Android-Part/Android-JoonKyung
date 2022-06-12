package com.lee989898.soptlee.data.local.datasource

import com.lee989898.soptlee.data.LocalPreferences

interface LocalTokenDataSource {

    fun getAccessToken(): String
}