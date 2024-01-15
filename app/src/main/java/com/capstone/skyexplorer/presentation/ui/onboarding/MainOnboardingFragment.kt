package com.capstone.skyexplorer.presentation.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.capstone.skyexplorer.R
import com.capstone.skyexplorer.databinding.FragmentMainOnboardingBinding
import com.capstone.skyexplorer.presentation.ui.onboarding.adapter.OnboardingViewpagerAdapter

class MainOnboardingFragment : Fragment() {

    private lateinit var binding: FragmentMainOnboardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainOnboardingBinding.inflate(inflater, container, false)
        onBoardingViewpager()
        return binding.root
    }

    private fun onBoardingViewpager() {
        val fragmentList = arrayListOf<Fragment>(
            FirstOnboardingFragment(),
            SecondOnboardingFragment(),
            ThirdOnboardingFragment()
        )

        val viewPagerAdapter = OnboardingViewpagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding.onBoardingContainer.adapter = viewPagerAdapter
    }
}