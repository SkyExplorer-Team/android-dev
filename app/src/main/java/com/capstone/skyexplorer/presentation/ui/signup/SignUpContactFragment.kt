package com.capstone.skyexplorer.presentation.ui.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.capstone.skyexplorer.R
import com.capstone.skyexplorer.databinding.FragmentSignUpContactBinding
import com.capstone.skyexplorer.databinding.FragmentSignUpPersonalBinding


class SignUpContactFragment : Fragment() {

    private var _binding: FragmentSignUpContactBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignUpContactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnSignIn.setOnClickListener {
                findNavController().navigate(R.id.action_signUpContactFragment_to_signUpCheckFragment)
            }
            btnBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }
}