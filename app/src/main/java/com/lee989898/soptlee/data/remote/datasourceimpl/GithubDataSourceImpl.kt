package com.lee989898.soptlee.data.remote.datasourceimpl

import com.lee989898.soptlee.data.remote.api.GithubService
import com.lee989898.soptlee.data.remote.datasource.GithubDataSource
import com.lee989898.soptlee.data.remote.model.github.ResponseGitHubFollower
import javax.inject.Inject

class GithubDataSourceImpl @Inject constructor(
    private val githubService: GithubService
): GithubDataSource {

    override suspend fun getGithubFollower(username: String): List<ResponseGitHubFollower> = githubService.getGithubFollower(username)
}