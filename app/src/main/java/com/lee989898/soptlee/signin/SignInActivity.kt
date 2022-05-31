package com.lee989898.soptlee.signin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.lee989898.soptlee.R
import com.lee989898.soptlee.databinding.ActivitySignInBinding
import com.lee989898.soptlee.main.HomeActivity
import com.lee989898.soptlee.signin.viewmodel.SignInViewModel
import com.lee989898.soptlee.signup.SignUpActivity
import com.lee989898.soptlee.util.SharedPreferences
import com.lee989898.soptlee.util.binding.BindingActivity
import com.lee989898.soptlee.util.showToast

class SignInActivity : BindingActivity<ActivitySignInBinding>(R.layout.activity_sign_in) {

    private val signInViewModel by viewModels<SignInViewModel>()
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.signInViewModel = signInViewModel
        binding.signInActivity = this
        resultLauncher = activityResultLauncher()
        observeSignInMessage()
        observeLogin()
        SharedPreferences.init(this)
        isAutoLogin()
    }

    fun autoLogin() {
        binding.ivAutoLogin.isSelected = !binding.ivAutoLogin.isSelected
        SharedPreferences.setAutoLogin(binding.ivAutoLogin.isSelected)
    }

    private fun isAutoLogin() {
        if (SharedPreferences.getAutoLogin()) {
            showToast("자동로그인 되었습니다")
            startActivity(Intent(this@SignInActivity, HomeActivity::class.java))
        }
    }

    fun goToSignUp() {
        val intent = Intent(this, SignUpActivity::class.java)
        resultLauncher.launch(intent)
        finish()
    }

    private fun activityResultLauncher(): ActivityResultLauncher<Intent> {
        val resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    val signUpData = result.data ?: return@registerForActivityResult
                    signInViewModel.email.value = signUpData.getStringExtra("id")
                    signInViewModel.password.value = signUpData.getStringExtra("pwd")
                }
            }
        return resultLauncher
    }

    private fun observeLogin() {
        signInViewModel.loginSuccess.observe(this) {
            startActivity(Intent(this@SignInActivity, HomeActivity::class.java))
            finish()
        }
    }

    private fun observeSignInMessage() {
        signInViewModel.statusMessage.observe(this) {
            it.getContentIfNotHandled()?.let {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        }
    }

}