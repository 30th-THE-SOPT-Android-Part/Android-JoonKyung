package com.lee989898.soptlee.signup.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lee989898.soptlee.retrofit.RetrofitInstance
import com.lee989898.soptlee.signup.data.RequestSignUp
import com.lee989898.soptlee.util.Event
import com.lee989898.soptlee.util.enqueueUtil

enum class NoticeType {
    NAME, ID, PWD
}

class SignUpViewModel : ViewModel() {

    private val _statusMessage = MutableLiveData<Event<String>>()
    val statusMessage: LiveData<Event<String>>
        get() = _statusMessage

    private val _notice = MutableLiveData<String>()
    val notice: LiveData<String>
        get() = _notice

    private val _joinSuccess = MutableLiveData<Boolean>()
    val joinSuccess: LiveData<Boolean>
        get() = _joinSuccess

    val name = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()


    fun signUp() {
        when {
            name.value.isNullOrBlank() -> updateNotice(NoticeType.NAME)
            email.value.isNullOrBlank() -> updateNotice(NoticeType.ID)
            password.value.isNullOrBlank() -> updateNotice(NoticeType.PWD)
            else -> {
                signUpNetwork()
            }
        }
    }

    private fun signUpNetwork() {
        val requestSignUp = RequestSignUp(
            name.value!!,
            email.value!!,
            password.value!!
        )

        val call = RetrofitInstance.AUTH_SERVICE.postSignUp(requestSignUp)

        call.enqueueUtil(
            onSuccess = {
                _joinSuccess.value = true
                _statusMessage.postValue(Event("회원가입에 성공하셨습니다"))
            },
            onError = {
                _statusMessage.postValue(Event("회원가입에 실패하셨습니다"))
            }
        )
    }

    private fun updateNotice(noticeType: NoticeType) {
        when (noticeType) {
            NoticeType.NAME ->
                _notice.value = "이름이 없음"
            NoticeType.ID ->
                _notice.value = "아이디가 없음"
            NoticeType.PWD ->
                _notice.value = "비밀번호가 없음"
        }
    }

}