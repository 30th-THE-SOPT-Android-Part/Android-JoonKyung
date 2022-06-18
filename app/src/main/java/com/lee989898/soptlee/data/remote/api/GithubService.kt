package com.lee989898.soptlee.data.remote.api

import com.lee989898.soptlee.data.remote.model.github.ResponseGitHubFollower
import retrofit2.http.*

interface GithubService {

    @GET("users/{username}/followers")
    suspend fun getGithubFollower(
        @Path("username") username: String
    ): List<ResponseGitHubFollower>
}