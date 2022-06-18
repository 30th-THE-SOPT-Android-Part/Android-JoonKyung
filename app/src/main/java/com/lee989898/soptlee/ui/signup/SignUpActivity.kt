package com.lee989898.soptlee.ui.signup

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.lee989898.soptlee.*
import com.lee989898.soptlee.ui.signin.SignInActivity
import com.lee989898.soptlee.databinding.ActivitySignUpBinding
import com.lee989898.soptlee.ui.signup.viewmodel.SignUpViewModel
import com.lee989898.soptlee.util.binding.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpActivity : BindingActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {

    private val signUpViewModel by viewModels<SignUpViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.signUpViewModel = signUpViewModel
        observeSignUpMessage()
        observeSignUpSuccess()
    }

    private fun observeSignUpMessage() {
        signUpViewModel.statusMessage.observe(this) { event ->
            event.getContentIfNotHandled()?.let {
                Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
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