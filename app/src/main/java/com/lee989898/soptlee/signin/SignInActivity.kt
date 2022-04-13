package com.lee989898.soptlee.signin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.lee989898.soptlee.databinding.ActivitySignInBinding
import com.lee989898.soptlee.main.HomeActivity
import com.lee989898.soptlee.signup.SignUpActivity

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater).also { setContentView(it.root) }

        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
            if(result.resultCode == Activity.RESULT_OK){
                val myData = result.data ?: return@registerForActivityResult
                binding.signInIdEt.setText(myData.getStringExtra("id"))
                binding.signInPasswordEt.setText(myData.getStringExtra("pwd"))
            }
        }

        binding.signInLoginBt.setOnClickListener {
            if (binding.signInIdEt.text.isNullOrBlank() || binding.signInPasswordEt.text.isNullOrBlank()) {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }

        binding.signInJoinBt.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            resultLauncher.launch(intent)
        }

    }
}