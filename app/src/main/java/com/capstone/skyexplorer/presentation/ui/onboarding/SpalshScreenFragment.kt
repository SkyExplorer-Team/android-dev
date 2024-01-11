package com.capstone.skyexplorer.presentation.ui.onboarding

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.capstone.skyexplorer.R

class SpalshScreenFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        moveToAnotherFragment()
        return inflater.inflate(R.layout.fragment_spalsh_screen, container, false)
    }

    private fun  moveToAnotherFragment(){
        Handler().postDelayed({
            if (checkOnboardingFinished()){
                //
            }else {

            }
        }, 3000)
    }
    private fun checkOnboardingFinished(): Boolean {
        return false
    }

}