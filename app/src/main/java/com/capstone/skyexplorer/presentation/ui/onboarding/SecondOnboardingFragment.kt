package com.capstone.skyexplorer.presentation.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.capstone.skyexplorer.R
import com.capstone.skyexplorer.databinding.FragmentSecondOnboardingBinding


class SecondOnboardingFragment : Fragment() {
    private lateinit var binding: FragmentSecondOnboardingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondOnboardingBinding.inflate(inflater, container, false)
        slideToNextFragment()
        return binding.root
    }

    private fun slideToNextFragment(){
        val onboardingViewpagerContainer = activity?.findViewById<ViewPager2>(R.id.onBoardingContainer)
        binding.btnNext.setOnClickListener {
            onboardingViewpagerContainer?.currentItem = 1
        }
    }

}