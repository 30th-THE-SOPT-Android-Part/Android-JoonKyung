package com.lee989898.soptlee.signin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lee989898.soptlee.retrofit.JoinRetrofitInstance
import com.lee989898.soptlee.signin.data.RequestSignIn
import com.lee989898.soptlee.util.Event
import com.lee989898.soptlee.util.enqueueUtil

class SignInViewModel : ViewModel() {

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
        val requestSignIn = RequestSignIn(
            email.value!!,
            password.value!!
        )

        val call = JoinRetrofitInstance.JOIN_SERVICE.postLogin(requestSignIn)

        call.enqueueUtil(
            onSuccess = {
                _loginSuccess.value = true
                val data = it.data
                _statusMessage.postValue(Event("${data.email}님 반갑습니다!"))
            },
            onError = {
                _statusMessage.postValue(Event("회원정보가 틀립니다."))
            }
        )
    }
}