package com.lee989898.soptlee.ui.signin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lee989898.soptlee.domain.repository.AuthRepository
import com.lee989898.soptlee.data.remote.model.auth.signin.RequestSignIn
import com.lee989898.soptlee.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _statusMessage = MutableLiveData<Event<String>>()
    val statusMessage: LiveData<Event<String>>
        get() = _statusMessage

    private val _loginSuccess = MutableLiveData<Boolean>()
    val loginSuccess: LiveData<Boolean>
        get() = _loginSuccess

    var email = MutableLiveData<String>()
    var password = MutableLiveData<String>()

    fun signIn() {
        if (email.value.isNullOrBlank() || password.value.isNullOrBlank()) {
            _statusMessage.postValue(Event("아이디/비밀번호를 확인해주세요"))
        } else {
            loginNetwork()
        }
    }

    private fun loginNetwork() {
        viewModelScope.launch {
            authRepository.postSignIn(
                RequestSignIn(
                    requireNotNull(email.value),
                    requireNotNull(password.value)
                )
            ).onSuccess {
                _loginSuccess.value = true
                val data = it.data
                _statusMessage.postValue(Event("${data.email}님 반갑습니다!"))
            }.onFailure {
                _statusMessage.postValue(Event("회원정보가 틀립니다."))
            }
        }
    }
}