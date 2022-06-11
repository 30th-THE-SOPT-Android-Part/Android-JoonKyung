package com.lee989898.soptlee.retrofit

import com.google.gson.GsonBuilder
import com.lee989898.soptlee.service.GitHubService
import com.lee989898.soptlee.service.AuthService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val AUTH_BASE_URL = "http://13.124.62.236/"
    private const val GITHUB_BASE_URL = "http://api.github.com/"

    private val authRetrofit: Retrofit = Retrofit.Builder()
        .baseUrl(AUTH_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()

    private val githubRetrofit: Retrofit = Retrofit.Builder()
        .baseUrl(GITHUB_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()

    val AUTH_SERVICE: AuthService = authRetrofit.create(AuthService::class.java)
    val GITHUB_SERVICE: GitHubService = githubRetrofit.create(GitHubService::class.java)
}