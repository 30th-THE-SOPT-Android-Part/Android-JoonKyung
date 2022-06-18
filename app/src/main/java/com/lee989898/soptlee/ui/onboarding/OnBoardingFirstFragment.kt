package com.lee989898.soptlee.ui.onboarding

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.lee989898.soptlee.R
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