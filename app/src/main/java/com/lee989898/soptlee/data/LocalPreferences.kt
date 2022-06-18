package com.lee989898.soptlee.data

import android.content.Context
import android.content.SharedPreferences

object LocalPreferences {
    private const val ACCESS_TOKEN = "ACCESS_TOKEN"

    private lateinit var localPreferences: SharedPreferences

    fun init(context: Context) {
        localPreferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    }

    fun getAccessToken() =
        localPreferences.getString(ACCESS_TOKEN, "") ?: ""
}