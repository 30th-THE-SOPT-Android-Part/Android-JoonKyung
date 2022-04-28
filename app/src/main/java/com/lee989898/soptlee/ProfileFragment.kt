package com.lee989898.soptlee

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.lee989898.soptlee.databinding.FragmentProfileBinding
import com.lee989898.soptlee.follower.FollowerFragment
import com.lee989898.soptlee.repository.RepositoryFragment

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_profile, container, false)



        initTransactionEvent()

        return binding.root
    }

    private fun initTransactionEvent(){
        val followerFragment = FollowerFragment()
        val repositoryFragment = RepositoryFragment()

        buttonSelected(true)

        parentFragmentManager.beginTransaction().add(R.id.profile_fragment_fcv, followerFragment).commit()


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
        val transaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.profile_fragment_fcv, replaceFragment)
        transaction.commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}