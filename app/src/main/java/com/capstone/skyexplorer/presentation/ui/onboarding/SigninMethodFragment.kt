package com.capstone.skyexplorer.presentation.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.capstone.skyexplorer.R
import com.capstone.skyexplorer.databinding.FragmentSigninMethodBinding

class SigninMethodFragment : Fragment() {
    private var _binding: FragmentSigninMethodBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSigninMethodBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnEmail.setOnClickListener {
                findNavController().navigate(R.id.action_signinMethodFragment_to_signUpPersonalFragment)
            }
            tvSignIn.setOnClickListener {
                findNavController().navigate(R.id.action_signinMethodFragment_to_signInFragment)
            }
        }
    }

}