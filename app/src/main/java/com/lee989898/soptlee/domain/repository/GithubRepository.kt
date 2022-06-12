package com.lee989898.soptlee.domain.repository

import com.lee989898.soptlee.ui.follower.data.ResponseGitHubFollowerItem
import com.lee989898.soptlee.ui.signin.data.ResponseSignIn
import com.lee989898.soptlee.util.response.BaseResponse

interface GithubRepository {

    suspend fun getGithubFollower(
        username: String
    ): Result<List<ResponseGitHubFollowerItem>>
}