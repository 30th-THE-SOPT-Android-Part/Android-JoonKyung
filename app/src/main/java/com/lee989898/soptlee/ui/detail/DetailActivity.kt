package com.lee989898.soptlee.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import com.lee989898.soptlee.R
import com.lee989898.soptlee.databinding.ActivityDetailBinding
import com.lee989898.soptlee.ui.detail.viewmodel.DetailViewModel
import com.lee989898.soptlee.util.binding.BindingActivity

class DetailActivity : BindingActivity<ActivityDetailBinding>(R.layout.activity_detail) {

    private val detailViewModel by viewModels<DetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.detailViewModel = detailViewModel
        updateData()
    }

    private fun updateData() {
        detailViewModel.updateDetail(
            intent.getStringExtra("name").toString(),
            intent.getStringExtra("image").toString()
        )
    }
}