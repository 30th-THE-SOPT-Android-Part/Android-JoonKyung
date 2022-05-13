package com.lee989898.soptlee.signin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.lee989898.soptlee.BaseResponse
import com.lee989898.soptlee.retrofit.JoinRetrofitInstance
import com.lee989898.soptlee.databinding.ActivitySignInBinding
import com.lee989898.soptlee.main.HomeActivity
import com.lee989898.soptlee.signup.SignUpActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater).also { setContentView(it.root) }

        initEvent()

        val resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val myData = result.data ?: return@registerForActivityResult
                    binding.signInIdEt.setText(myData.getStringExtra("id"))
                    binding.signInPasswordEt.setText(myData.getStringExtra("pwd"))
                }
            }



        binding.signInJoinBt.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            resultLauncher.launch(intent)
        }

    }

    private fun initEvent() {
        binding.signInLoginBt.setOnClickListener {
            if (binding.signInIdEt.text.isNullOrBlank() || binding.signInPasswordEt.text.isNullOrBlank()) {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
            }

            loginNetwork()
        }
    }


    private fun loginNetwork() {
        var requestSignIn = RequestSignIn(
            id = binding.signInIdEt.text.toString(),
            password = binding.signInPasswordEt.text.toString()
        )

        val call = JoinRetrofitInstance.JOIN_SERVICE.postLogin(requestSignIn)

        call.enqueue(object : Callback<BaseResponse<ResponseSignIn>> {
            override fun onResponse(
                call: Call<BaseResponse<ResponseSignIn>>,
                response: Response<BaseResponse<ResponseSignIn>>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()?.data

                    Toast.makeText(
                        this@SignInActivity,
                        "${data?.email}님 반갑습니다!",
                        Toast.LENGTH_SHORT
                    ).show()
                    startActivity(Intent(this@SignInActivity, HomeActivity::class.java))
                } else Toast.makeText(this@SignInActivity, "로그인에 실패하셨습니다.", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onFailure(call: Call<BaseResponse<ResponseSignIn>>, t: Throwable) {
                Log.e("NetworkTest", "error:$t")
            }

        })
    }
}