package com.lee989898.soptlee.home

import android.os.Bundle
import android.view.View
import com.google.android.material.tabs.TabLayoutMediator
import com.lee989898.soptlee.R
import com.lee989898.soptlee.databinding.FragmentHomeBinding
import com.lee989898.soptlee.util.binding.BindingFragment

class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private lateinit var homeTabViewPagerAdapter: HomeTabViewPagerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initTabLayout()
    }

    private fun initAdapter() {
        val fragmentList = listOf(HomeFollowerFragment(), HomeFollowingFragment())

        homeTabViewPagerAdapter = HomeTabViewPagerAdapter(this)
        homeTabViewPagerAdapter.fragments.addAll(fragmentList)

        binding.homeViewPagerVp.adapter = homeTabViewPagerAdapter
    }

    private fun initTabLayout() {
        val tabLabel = listOf("팔로잉", "팔로워")

        TabLayoutMediator(binding.homeTabTl, binding.homeViewPagerVp) { tab, position ->
            tab.text = tabLabel[position]
        }.attach()
    }


}