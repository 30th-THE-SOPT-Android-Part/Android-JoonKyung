package com.lee989898.soptlee.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.lee989898.soptlee.*
import com.lee989898.soptlee.databinding.ActivityHomeBinding
import com.lee989898.soptlee.follower.FollowerFragment
import com.lee989898.soptlee.repository.RepositoryFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initTransactionEvent()
    }

    private fun initTransactionEvent() {
        val followerFragment = FollowerFragment()
        val repositoryFragment = RepositoryFragment()

        supportFragmentManager.beginTransaction().add(R.id.home_list_fcv, followerFragment).commit()

        binding.homeRepoListBt.setOnClickListener {
            replaceFragment(ProfileFragment())
        }

        binding.homeFollowerListBt.setOnClickListener {
            replaceFragment(followerFragment)
        }

    }

    private fun replaceFragment(replaceFragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.home_list_fcv, replaceFragment)
        transaction.commit()
    }
}