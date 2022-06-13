package com.lee989898.soptlee.data.remote.datasource

import com.lee989898.soptlee.data.remote.model.github.ResponseGitHubFollower

interface GithubDataSource {
    suspend fun getGithubFollower(username: String): List<ResponseGitHubFollower>
}