package com.lee989898.soptlee.data.remote.api

import com.lee989898.soptlee.ui.follower.data.ResponseGitHubFollowerItem
import retrofit2.Response
import retrofit2.http.*

interface GithubService {

    @GET("users/{username}/followers")
    suspend fun getGithubFollower(
        @Path("username") username: String
    ): List<ResponseGitHubFollowerItem>
}