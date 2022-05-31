package com.lee989898.soptlee

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.lee989898.soptlee.databinding.FragmentOnboardingFirstBinding
import com.lee989898.soptlee.util.binding.BindingFragment

class OnBoardingFirstFragment : BindingFragment<FragmentOnboardingFirstBinding>(R.layout.fragment_onboarding_first) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btNext.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardingFirstFragment_to_onBoardingSecondFragment)
        }

    }
}