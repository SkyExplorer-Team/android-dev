package com.capstone.skyexplorer.presentation.ui.signin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.capstone.skyexplorer.R
import com.capstone.skyexplorer.databinding.FragmentSignInBinding
import com.capstone.skyexplorer.databinding.FragmentSigninMethodBinding
import com.capstone.skyexplorer.model.auth.login.LoginResponse
import com.capstone.skyexplorer.model.auth.login.PostLoginModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
@AndroidEntryPoint
class SignInFragment : Fragment() {
    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LoginViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            viewModel.state.collect { uiState ->
                loadingStateIsToggled(uiState.isLoading)
                errorStateIsToggled(uiState.isError)
                uiState.loginResult?.let { successStateIsToggled(it) }
            }
        }
        binding.apply {
            btnSignIn.setOnClickListener {
                viewModel.login(
                    PostLoginModel(email = "", password = "")
                )
            }
            tvForgotPasswod.setOnClickListener {
                findNavController().navigate(
                    R.id.action_signInFragment_to_forgotEmailFragment
                )
            }
        }
    }
    private fun loadingStateIsToggled(isLoading : Boolean){

    }
    private fun errorStateIsToggled(isError : Boolean){

    }
    private fun successStateIsToggled(loginResult : LoginResponse){

    }
}