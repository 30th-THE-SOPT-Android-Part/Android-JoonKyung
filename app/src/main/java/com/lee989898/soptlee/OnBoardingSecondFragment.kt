package com.lee989898.soptlee

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
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