package com.lee989898.soptlee.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lee989898.soptlee.signup.NoticeType

class DetailViewModel : ViewModel() {

    private val _name = MutableLiveData<String>()
    private val _introduce = MutableLiveData<String>()


    val name: LiveData<String>
        get() = _name
    val introduce: LiveData<String>
        get() = _introduce

    init {
        _name.value = ""
        _introduce.value = ""
    }

    fun updateDetail(name: String, introduce: String){
        _name.value = name
        _introduce.value = introduce
    }


}