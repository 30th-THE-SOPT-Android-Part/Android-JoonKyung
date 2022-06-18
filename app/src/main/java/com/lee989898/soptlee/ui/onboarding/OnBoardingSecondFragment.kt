package com.lee989898.soptlee.ui.onboarding

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.lee989898.soptlee.R
import com.lee989898.soptlee.databinding.FragmentOnboardingSecondBinding
import com.lee989898.soptlee.util.binding.BindingFragment

class OnBoardingSecondFragment : BindingFragment<FragmentOnboardingSecondBinding>(R.layout.fragment_onboarding_second) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btNext.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardingSecondFragment_to_onBoardingThirdFragment)
        }

    }
}