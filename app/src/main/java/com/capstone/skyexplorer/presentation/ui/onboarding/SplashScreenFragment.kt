package com.capstone.skyexplorer.presentation.ui.onboarding

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.capstone.skyexplorer.R

class SplashScreenFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        moveToAnotherFragment()
        return inflater.inflate(R.layout.fragment_spalsh_screen, container, false)
    }

    private fun  moveToAnotherFragment(){
        Handler().postDelayed({
            if (checkOnboardingFinished()){
                findNavController().navigate(R.id.action_spalshScreenFragment_to_mainOnboardingFragment)
            }else {
                findNavController().navigate(R.id.action_spalshScreenFragment_to_signinMethodFragment)
            }
        }, 3000)
    }
    private fun checkOnboardingFinished(): Boolean {
        return true
    }

}