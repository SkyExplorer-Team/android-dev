package com.capstone.skyexplorer.presentation.ui.signin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.capstone.skyexplorer.R
import com.capstone.skyexplorer.databinding.FragmentSignInBinding
import com.capstone.skyexplorer.databinding.FragmentSigninMethodBinding


class SignInFragment : Fragment() {
    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnSignIn.setOnClickListener {

            }
            tvForgotPasswod.setOnClickListener {
                findNavController().navigate(
                    R.id.action_signInFragment_to_forgotEmailFragment
                )
            }
            btnBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }
}