package com.capstone.skyexplorer.presentation.ui.forgotPassword

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.capstone.skyexplorer.R
import com.capstone.skyexplorer.databinding.FragmentChangePasswordSuccessBinding
import com.capstone.skyexplorer.databinding.FragmentCreateNewPasswordBinding


class ChangePasswordSuccess : Fragment() {

    private var _binding: FragmentChangePasswordSuccessBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =   FragmentChangePasswordSuccessBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnPrimaryButton.setOnClickListener {
                findNavController().navigate(R.id.action_changePasswordSuccess_to_signInFragment)
            }
        }
    }

}