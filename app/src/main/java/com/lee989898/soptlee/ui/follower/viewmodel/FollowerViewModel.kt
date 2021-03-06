package com.lee989898.soptlee.ui.follower.viewmodel

import androidx.lifecycle.*
import com.lee989898.soptlee.ui.follower.adapter.FollowerData
import com.lee989898.soptlee.domain.repository.GithubRepository
import com.lee989898.soptlee.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class FollowerViewModel @Inject constructor(
    private val githubRepository: GithubRepository
) : ViewModel() {

    private val _statusMessage = MutableLiveData<Event<String>>()
    val statusMessage: LiveData<Event<String>>
        get() = _statusMessage

    private val _followData = MutableLiveData<List<FollowerData>>()
    val followData: LiveData<List<FollowerData>>
        get() = _followData

    fun getGithubFollower() {
        val data = mutableListOf<FollowerData>()

        viewModelScope.launch {
            githubRepository.getGithubFollower(
                "lee989898"
            ).onSuccess {
                for (i in it.indices) {
                    data.add(
                        FollowerData(
                            it[i].login,
                            it[i].avatar_url
                        )
                    )
                }
                _followData.value = data
            }.onFailure {
                Timber.tag("getFollower").d(it.message.toString())
                _statusMessage.postValue(Event("깃허브 팔로우 불러오는데 실패했습니다."))
            }
        }
    }
}