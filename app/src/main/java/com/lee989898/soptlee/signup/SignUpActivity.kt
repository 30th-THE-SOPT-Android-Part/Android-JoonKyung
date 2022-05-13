package com.lee989898.soptlee.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.lee989898.soptlee.retrofit.JoinRetrofitInstance
import com.lee989898.soptlee.*
import com.lee989898.soptlee.signin.SignInActivity
import com.lee989898.soptlee.databinding.ActivitySignUpBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    lateinit var signUpViewModel: SignUpViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)

        signUpViewModel = ViewModelProvider(this)[SignUpViewModel::class.java]

        signUpCheck()

        binding.signUpJoinBt.setOnClickListener {
            when {
                binding.signUpNameEt.text.isNullOrBlank() -> signUpViewModel.updateNotice(NoticeType.NAME)
                binding.signUpIdEt.text.isNullOrBlank() -> signUpViewModel.updateNotice(NoticeType.ID)
                binding.signUpPasswordEt.text.isNullOrBlank() -> signUpViewModel.updateNotice(
                    NoticeType.PWD
                )
                else -> {
                    val intent = Intent(baseContext, SignInActivity::class.java)
                    intent.putExtra("id", binding.signUpIdEt.text.toString())
                    intent.putExtra("pwd", binding.signUpPasswordEt.text.toString())
                    setResult(RESULT_OK, intent)
                }
            }
            signUpNetwork()
        }

    }

    private fun signUpNetwork() {
        var requestSignUp = RequestSignUp(
            name = binding.signUpNameEt.text.toString(),
            id = binding.signUpIdEt.text.toString(),
            password = binding.signUpPasswordEt.text.toString()
        )

        val call = JoinRetrofitInstance.JOIN_SERVICE.postSignUp(requestSignUp)

        call.enqueue(object: Callback<ResponseSignUp> {
            override fun onResponse(
                call: Call<ResponseSignUp>,
                response: Response<ResponseSignUp>
            ) {
                if(response.isSuccessful){
                    Toast.makeText(this@SignUpActivity, "회원가입에 성공하셨습니다", Toast.LENGTH_SHORT).show()
                    val intent = Intent(baseContext, SignInActivity::class.java)
                    intent.putExtra("id", binding.signUpIdEt.text.toString())
                    intent.putExtra("pwd", binding.signUpPasswordEt.text.toString())
                    setResult(RESULT_OK, intent)
                    finish()
                }else Toast.makeText(this@SignUpActivity, "실패", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<ResponseSignUp>, t: Throwable) {
                Log.e("NetworkTest", "error:$t")
            }

        })

    }

    private fun signUpCheck() {

        signUpViewModel.notice.observe(this) {
            binding.signUpNoticeTv.text = it.toString()
        }

    }
}