package com.lee989898.soptlee.ui.signup.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lee989898.soptlee.domain.repository.AuthRepository
import com.lee989898.soptlee.data.remote.model.auth.signup.RequestSignUp
import com.lee989898.soptlee.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class NoticeType {
    NAME, ID, PWD
}

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

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
        viewModelScope.launch {
            authRepository.postSignUp(
                RequestSignUp(
                    requireNotNull(name.value),
                    requireNotNull(email.value),
                    requireNotNull(password.value)
                )
            ).onSuccess {
                _joinSuccess.value = true
                _statusMessage.postValue(Event("회원가입에 성공하셨습니다"))
            }.onFailure {
                _statusMessage.postValue(Event("회원가입에 실패하셨습니다"))
            }
        }
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