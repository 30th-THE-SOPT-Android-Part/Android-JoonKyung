package com.lee989898.soptlee.service

import com.lee989898.soptlee.follower.data.ResponseGitHubFollowerItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {

    @GET("users/{username}/followers")
    suspend fun getGithubFollower(
        @Path("username") username: String
    ): Response<List<ResponseGitHubFollowerItem>>
}