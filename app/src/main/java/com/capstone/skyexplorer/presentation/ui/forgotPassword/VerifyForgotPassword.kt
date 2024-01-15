package com.capstone.skyexplorer.presentation.ui.forgotPassword

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.capstone.skyexplorer.R
import com.capstone.skyexplorer.databinding.FragmentForgotEmailBinding
import com.capstone.skyexplorer.databinding.FragmentVerifyForgotPasswordBinding

class VerifyForgotPassword : Fragment() {

    private var _binding: FragmentVerifyForgotPasswordBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVerifyForgotPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnResendVerification.setOnClickListener {
                findNavController().navigate(R.id.action_verifyForgotPassword_to_createNewPasswordFragment)
            }
        }
    }
}