package com.lee989898.soptlee.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

enum class NoticeType{
    NAME, ID, PWD
}

class SignUpViewModel : ViewModel() {

    private val _notice = MutableLiveData<String>()

    val notice: LiveData<String>
        get() = _notice

    init {
        _notice.value = ""
    }

    fun updateNotice(noticeType: NoticeType){
        when(noticeType){
            NoticeType.NAME ->
                _notice.value = "이름이 없음"
            NoticeType.ID ->
                _notice.value = "아이디가 없음"
            NoticeType.PWD ->
                _notice.value = "비밀번호가 없음"
        }
    }

}