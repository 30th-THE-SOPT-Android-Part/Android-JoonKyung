package com.lee989898.soptlee

import com.lee989898.soptlee.github.ResponseGitHubFollowerItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {

    @GET("users/{username}/followers")
    fun getGithubFollower(
        @Path("username") username: String): Call<List<ResponseGitHubFollowerItem>>
}