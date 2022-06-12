package com.lee989898.soptlee.data.remote.datasource

import com.lee989898.soptlee.ui.follower.data.ResponseGitHubFollowerItem
import com.lee989898.soptlee.ui.signin.data.ResponseSignIn
import com.lee989898.soptlee.util.response.BaseResponse
import okhttp3.RequestBody
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubDataSource {
    suspend fun getGithubFollower(username: String): List<ResponseGitHubFollowerItem>
}