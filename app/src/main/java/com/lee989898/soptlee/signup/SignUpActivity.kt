package com.lee989898.soptlee.signup

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.lee989898.soptlee.R
import com.lee989898.soptlee.signin.SignInActivity
import com.lee989898.soptlee.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    var notice = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        binding.signup = this

        binding.signUpJoinBt.setOnClickListener {
            if (binding.signUpNameEt.text.isNullOrBlank()) {
//                Toast.makeText(this, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
                notice = "이름 비었음"
                binding.invalidateAll()
            } else if (binding.signUpIdEt.text.isNullOrBlank()) {
                notice = "아이디 비었음"
                binding.invalidateAll()
            } else if( binding.signUpPasswordEt.text.isNullOrBlank()){
                notice = "패스워드 비었음"
                binding.invalidateAll()
            } else {
                val intent = Intent(this, SignInActivity::class.java)
                intent.putExtra("id", binding.signUpIdEt.text.toString())
                intent.putExtra("pwd", binding.signUpPasswordEt.text.toString())
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }

    }
}