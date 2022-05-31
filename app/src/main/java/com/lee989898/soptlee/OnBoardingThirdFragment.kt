package com.lee989898.soptlee

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.lee989898.soptlee.databinding.FragmentOnboardingThirdBinding
import com.lee989898.soptlee.signin.SignInActivity
import com.lee989898.soptlee.util.binding.BindingFragment

class OnBoardingThirdFragment :
    BindingFragment<FragmentOnboardingThirdBinding>(R.layout.fragment_onboarding_third) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btNext.setOnClickListener {
            startActivity(Intent(activity, SignInActivity::class.java))
            activity?.finish()
        }
    }
}