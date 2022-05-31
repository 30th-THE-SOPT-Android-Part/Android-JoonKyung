package com.lee989898.soptlee.follower.viewmodel

import androidx.lifecycle.*
import com.lee989898.soptlee.follower.data.FollowerData
import com.lee989898.soptlee.retrofit.GitHubRetrofitInstance
import com.lee989898.soptlee.service.GitHubService
import kotlinx.coroutines.launch

class FollowerViewModel : ViewModel() {

    val followData = MutableLiveData<List<FollowerData>>()

    fun getGithubFollower() {
        viewModelScope.launch {
            val retService =
                GitHubRetrofitInstance.getRetrofitInstance().create(GitHubService::class.java)

            val data = mutableListOf<FollowerData>()

            val response = retService.getGithubFollower("lee989898")
            for (i in 0 until response.body()!!.size) {
                data.add(
                    FollowerData(
                        response.body()?.get(i)?.login.toString(),
                        response.body()?.get(i)?.avatar_url.toString()
                    )
                )
            }
            followData.value = data
        }
    }
}