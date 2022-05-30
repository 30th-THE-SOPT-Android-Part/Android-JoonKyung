package com.lee989898.soptlee.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.lee989898.soptlee.retrofit.JoinRetrofitInstance
import com.lee989898.soptlee.*
import com.lee989898.soptlee.signin.SignInActivity
import com.lee989898.soptlee.databinding.ActivitySignUpBinding
import com.lee989898.soptlee.util.binding.BindingActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : BindingActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {

    private val signUpViewModel by viewModels<SignUpViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.signUpViewModel = signUpViewModel
        observeSignUpMessage()
        observeSignUpSuccess()
    }

    private fun observeSignUpMessage() {
        signUpViewModel.statusMessage.observe(this) {
            it.getContentIfNotHandled()?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun observeSignUpSuccess() {
        signUpViewModel.joinSuccess.observe(this) {
            val intent = Intent(this, SignInActivity::class.java)
            intent.putExtra("id", signUpViewModel.email.value)
            intent.putExtra("pwd", signUpViewModel.password.value)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}