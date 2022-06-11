package com.lee989898.soptlee.follower.viewmodel

import androidx.lifecycle.*
import com.lee989898.soptlee.follower.data.FollowerData
import com.lee989898.soptlee.retrofit.RetrofitInstance
import com.lee989898.soptlee.service.GitHubService
import com.lee989898.soptlee.util.Event
import kotlinx.coroutines.launch

class FollowerViewModel : ViewModel() {

    private val _followData = MutableLiveData<List<FollowerData>>()
    val followData: LiveData<List<FollowerData>>
        get() = _followData

    fun getGithubFollower() {
        viewModelScope.launch {
            val retService = RetrofitInstance.GITHUB_SERVICE

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
            _followData.value = data
        }
    }
}