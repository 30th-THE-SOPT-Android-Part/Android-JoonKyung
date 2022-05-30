package com.lee989898.soptlee.retrofit

import com.lee989898.soptlee.signin.data.JoinService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object JoinRetrofitInstance {
    private const val BASE_URL = "http://13.124.62.236/"

    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val JOIN_SERVICE: JoinService = retrofit.create(JoinService::class.java)
}