package com.lee989898.soptlee.util

import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.databinding.BindingAdapter
import com.lee989898.soptlee.R

object BindingAdapter {

    @JvmStatic
    @BindingAdapter(value = ["email", "pwd"], requireAll = true)
    fun setSignInBt(button: Button, email: String?, pwd: String?) {
        if (email.isNullOrBlank() || pwd.isNullOrBlank()) {
            button.setBackgroundResource(R.color.black)
        } else {
            button.setBackgroundResource(R.color.thesopt_purple)
        }
    }

    @JvmStatic
    @BindingAdapter(value = ["name","email", "pwd"], requireAll = true)
    fun setSignUpBt(button: Button,name: String?, email: String?, pwd: String?) {
        if (name.isNullOrBlank() || email.isNullOrBlank() || pwd.isNullOrBlank()) {
            button.setBackgroundResource(R.color.black)
        } else {
            button.setBackgroundResource(R.color.thesopt_purple)
        }
    }
}

