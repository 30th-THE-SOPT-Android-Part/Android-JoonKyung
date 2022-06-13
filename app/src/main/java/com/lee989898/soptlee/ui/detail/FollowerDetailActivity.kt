package com.lee989898.soptlee.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import com.lee989898.soptlee.R
import com.lee989898.soptlee.databinding.ActivityDetailBinding
import com.lee989898.soptlee.ui.detail.viewmodel.FollowerDetailViewModel
import com.lee989898.soptlee.util.binding.BindingActivity

class FollowerDetailActivity : BindingActivity<ActivityDetailBinding>(R.layout.activity_detail) {

    private val followerDetailViewModel by viewModels<FollowerDetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.detailViewModel = followerDetailViewModel
        updateData()
    }

    private fun updateData() {
        followerDetailViewModel.updateDetail(
            intent.getStringExtra("name").toString(),
            intent.getStringExtra("image").toString()
        )
    }
}