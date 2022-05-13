package com.lee989898.soptlee.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.lee989898.soptlee.R
import com.lee989898.soptlee.databinding.ActivityDetailBinding
import com.lee989898.soptlee.signup.SignUpViewModel

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    lateinit var detailViewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        detailViewModel = ViewModelProvider(this)[DetailViewModel::class.java]
        binding.lifecycleOwner = this

        detailViewModel.updateDetail(
            intent.getStringExtra("name").toString(),
            intent.getStringExtra("introduction").toString()
        )

        detailViewModel.name.observe(this) {
            binding.detailNameTv.text = it.toString()
        }

        detailViewModel.introduce.observe(this) {
            Glide.with(this)
                .load(it.toString())
                .into(binding.detailProfileIv)
        }
    }
}