package com.capstone.skyexplorer.presentation.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.capstone.skyexplorer.R
import com.capstone.skyexplorer.databinding.FragmentThirdOnboardingBinding

class ThirdOnboardingFragment : Fragment() {
    private lateinit var binding: FragmentThirdOnboardingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentThirdOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }
    private fun finishOnboarding(){

    }

}