package com.lee989898.soptlee.ui.main

import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.lee989898.soptlee.ui.camera.CameraFragment
import com.lee989898.soptlee.*
import com.lee989898.soptlee.databinding.ActivityHomeBinding
import com.lee989898.soptlee.ui.home.HomeFragment
import com.lee989898.soptlee.ui.main.adapter.HomeViewPagerAdapter
import com.lee989898.soptlee.ui.profile.ProfileFragment
import com.lee989898.soptlee.util.binding.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BindingActivity<ActivityHomeBinding>(R.layout.activity_home) {

    private lateinit var homeViewPagerAdapter: HomeViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initAdapter()
        initBottomNavi()
    }

    private fun initAdapter() {
        val fragmentList = listOf(ProfileFragment(), HomeFragment(), CameraFragment())
        homeViewPagerAdapter = HomeViewPagerAdapter(this)
        homeViewPagerAdapter.fragments.addAll(fragmentList)

        binding.homeVp.adapter = homeViewPagerAdapter

    }

    private fun initBottomNavi() {

        binding.homeVp.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.homeBnv.menu.getItem(position).isChecked = true
            }
        })

        binding.homeBnv.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home_profile -> {
                    binding.homeVp.currentItem = FIRST_FRAGMENT
                    return@setOnItemSelectedListener true
                }
                R.id.home_home -> {
                    binding.homeVp.currentItem = SECOND_FRAGMENT
                    return@setOnItemSelectedListener true
                }
                else -> {
                    binding.homeVp.currentItem = THIRD_FRAGMENT
                    return@setOnItemSelectedListener true
                }
            }
        }
    }

    companion object {
        const val FIRST_FRAGMENT = 0
        const val SECOND_FRAGMENT = 1
        const val THIRD_FRAGMENT = 2
    }
}