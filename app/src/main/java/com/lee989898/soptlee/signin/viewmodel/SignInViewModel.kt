package com.lee989898.soptlee.signin.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lee989898.soptlee.BaseResponse
import com.lee989898.soptlee.retrofit.JoinRetrofitInstance
import com.lee989898.soptlee.signin.data.RequestSignIn
import com.lee989898.soptlee.signin.data.ResponseSignIn
import com.lee989898.soptlee.util.Event
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        call.enqueue(object : Callback<BaseResponse<ResponseSignIn>> {
            override fun onResponse(
                call: Call<BaseResponse<ResponseSignIn>>,
                response: Response<BaseResponse<ResponseSignIn>>
            ) {
                if (response.isSuccessful) {
                    _loginSuccess.value = true
                    val data = response.body()?.data
                    _statusMessage.postValue(Event("${data?.email}님 반갑습니다!"))
                } else
                    _statusMessage.postValue(Event("회원정보가 틀립니다."))
            }
            override fun onFailure(call: Call<BaseResponse<ResponseSignIn>>, t: Throwable) {
                Log.e("NetworkTest", "error:$t")
            }

        })
    }
}