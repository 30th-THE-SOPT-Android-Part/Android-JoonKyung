package com.lee989898.soptlee.data.remote.repository

import com.lee989898.soptlee.data.remote.datasource.GithubDataSource
import com.lee989898.soptlee.domain.repository.GithubRepository
import com.lee989898.soptlee.ui.follower.data.ResponseGitHubFollowerItem
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(
    private val githubDataSource: GithubDataSource
) : GithubRepository {

    override suspend fun getGithubFollower(username: String): Result<List<ResponseGitHubFollowerItem>> =
        kotlin.runCatching {
            githubDataSource.getGithubFollower(username)
        }
}