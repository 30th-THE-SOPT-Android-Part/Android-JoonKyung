package com.lee989898.soptlee.domain.repository

import com.lee989898.soptlee.data.remote.model.github.ResponseGitHubFollower

interface GithubRepository {

    suspend fun getGithubFollower(
        username: String
    ): Result<List<ResponseGitHubFollower>>
}