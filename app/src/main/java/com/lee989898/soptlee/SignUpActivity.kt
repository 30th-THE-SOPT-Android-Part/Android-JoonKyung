package com.lee989898.soptlee

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.lee989898.soptlee.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.signUpJoinBt.setOnClickListener {
            if (binding.signUpNameEt.text.isNullOrBlank() || binding.signUpIdEt.text.isNullOrBlank() || binding.signUpPasswordEt.text.isNullOrBlank()) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
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