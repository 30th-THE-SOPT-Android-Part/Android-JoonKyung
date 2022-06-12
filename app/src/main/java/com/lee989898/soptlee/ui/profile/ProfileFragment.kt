package com.lee989898.soptlee.ui.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.lee989898.soptlee.R
import com.lee989898.soptlee.databinding.FragmentProfileBinding
import com.lee989898.soptlee.ui.follower.FollowerFragment
import com.lee989898.soptlee.ui.repository.RepositoryFragment
import com.lee989898.soptlee.ui.setting.SettingActivity
import com.lee989898.soptlee.util.binding.BindingFragment

class ProfileFragment : BindingFragment<FragmentProfileBinding>(R.layout.fragment_profile) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.profileFragment = this
        initTransactionEvent()
    }

    fun goToSetting() {
        startActivity(Intent(activity, SettingActivity::class.java))
    }

    private fun initTransactionEvent() {
        val followerFragment = FollowerFragment()
        val repositoryFragment = RepositoryFragment()

        buttonSelected(true)

        parentFragmentManager.beginTransaction().add(R.id.profile_fragment_fcv, followerFragment)
            .commit()

        binding.profileFollowerListBt.setOnClickListener {
            buttonSelected(true)
            replaceFragment(followerFragment)
        }
        binding.profileRepositoryListBt.setOnClickListener {
            buttonSelected(false)
            replaceFragment(repositoryFragment)
        }
    }

    private fun buttonSelected(select: Boolean) {
        binding.profileFollowerListBt.isSelected = select
        binding.profileRepositoryListBt.isSelected = !select
    }

    private fun replaceFragment(replaceFragment: Fragment) {
        parentFragmentManager.beginTransaction().replace(R.id.profile_fragment_fcv, replaceFragment)
            .commit()
    }

}