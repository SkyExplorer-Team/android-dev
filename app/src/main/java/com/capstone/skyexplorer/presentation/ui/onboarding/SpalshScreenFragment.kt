package com.capstone.skyexplorer.presentation.ui.onboarding

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.capstone.skyexplorer.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
@AndroidEntryPoint
class SpalshScreenFragment : Fragment() {
    private val viewModel : OnboardingViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_spalsh_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getShowOnBoarding()
        moveToAnotherFragment()
    }
    private fun  moveToAnotherFragment(){
        Handler().postDelayed({
            lifecycleScope.launch {
                viewModel.state.collect{
                    if (it.showOnBoarding){
                        findNavController().navigate(R.id.action_spalshScreenFragment_to_mainOnboardingFragment)
                    }else {
                        findNavController().navigate(R.id.action_spalshScreenFragment_to_signinMethodFragment)
                    }
                }
            }
        }, 3000)
    }


}