package com.lee989898.soptlee.ui.detail.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FollowerDetailViewModel : ViewModel() {

    private val _name = MutableLiveData<String>()
    val name: LiveData<String>
        get() = _name

    private val _image = MutableLiveData<String>()
    val image: LiveData<String>
        get() = _image

    fun updateDetail(name: String, introduce: String) {
        _name.value = name
        _image.value = introduce
    }
}