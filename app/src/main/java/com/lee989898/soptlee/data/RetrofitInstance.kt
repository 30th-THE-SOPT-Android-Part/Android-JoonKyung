package com.lee989898.soptlee.data

import com.lee989898.soptlee.data.remote.api.AuthService
import com.lee989898.soptlee.data.remote.api.GithubService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {
    private const val AUTH_BASE_URL = "http://13.124.62.236/"
    private const val GITHUB_BASE_URL = "http://api.github.com/"

    private val headerInterceptor = Interceptor { chain ->
        with(chain) {
            proceed(
                request()
                    .newBuilder()
                    .addHeader("X-ACCESS-TOKEN", LocalPreferences.getAccessToken())
                    .build()
            )
        }
    }

    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .addInterceptor(headerInterceptor)
        .build()

    private val authRetrofit: Retrofit = Retrofit.Builder()
        .baseUrl(AUTH_BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val githubRetrofit: Retrofit = Retrofit.Builder()
        .baseUrl(GITHUB_BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val AUTH_SERVICE: AuthService = authRetrofit.create(AuthService::class.java)
    val GITHUB_SERVICE: GithubService = githubRetrofit.create(GithubService::class.java)
}