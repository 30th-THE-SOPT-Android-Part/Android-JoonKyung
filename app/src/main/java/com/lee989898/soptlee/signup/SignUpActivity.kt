package com.lee989898.soptlee.signup

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.lee989898.soptlee.R
import com.lee989898.soptlee.signin.SignInActivity
import com.lee989898.soptlee.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    lateinit var signUpViewModel: SignUpViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)

        signUpViewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)

        signUpViewModel.notice.observe(this, Observer {
            binding.signUpNoticeTv.text = it.toString()
        })

        binding.signUpJoinBt.setOnClickListener {
            if (binding.signUpNameEt.text.isNullOrBlank()) {
                signUpViewModel.updateNotice(NoticeType.NAME)
            } else if (binding.signUpIdEt.text.isNullOrBlank()) {
                signUpViewModel.updateNotice(NoticeType.ID)
            } else if (binding.signUpPasswordEt.text.isNullOrBlank()) {
                signUpViewModel.updateNotice(NoticeType.PWD)
            } else {
                val intent = Intent(baseContext, SignInActivity::class.java)
                intent.putExtra("id", binding.signUpIdEt.text.toString())
                intent.putExtra("pwd", binding.signUpPasswordEt.text.toString())
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }

    }
}