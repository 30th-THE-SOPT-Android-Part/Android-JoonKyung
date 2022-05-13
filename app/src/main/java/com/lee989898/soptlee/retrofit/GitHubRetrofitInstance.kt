package com.lee989898.soptlee.retrofit

import com.google.gson.GsonBuilder
import com.lee989898.soptlee.github.GitHubService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class GitHubRetrofitInstance {

    companion object {
        val BASE_URL = "http://api.github.com/"

        fun getRetrofitInstance(): Retrofit{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
        }
    }

}