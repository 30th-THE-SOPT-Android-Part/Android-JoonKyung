package com.lee989898.soptlee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.lee989898.soptlee.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.detailNameTv.append(intent.getStringExtra("name"))
        binding.detailIntroductionTv.append(intent.getStringExtra("introduction"))
    }
}