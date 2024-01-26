package com.capstone.skyexplorer.presentation.ui.signin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.capstone.skyexplorer.R
import com.capstone.skyexplorer.databinding.FragmentSignInBinding
import com.capstone.skyexplorer.model.auth.login.LoginResponse
import com.capstone.skyexplorer.model.auth.login.PostLoginModel
import com.capstone.skyexplorer.utils.Validator
import com.capstone.skyexplorer.utils.Validator.emailValidator
import com.capstone.skyexplorer.utils.Validator.enableButtonOnValidation
import com.capstone.skyexplorer.utils.Validator.isValidEmail
import com.capstone.skyexplorer.utils.Validator.isValidMinLength
import com.capstone.skyexplorer.utils.Validator.passwordValidator
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
                updateUi(uiState)
            }
        }
        binding.apply {
            btnSignIn.isEnabled = false
            btnBack.setOnClickListener{
                findNavController().popBackStack()
            }
            // Disable error Icon
            edtEmail.errorIconDrawable = null
            edtPassword.errorIconDrawable = null

            // Email Validator && password Validator
            inputEmail.emailValidator(edtEmail)
            inputPassword.passwordValidator(edtPassword)

            // enable button
            val validationPairs = listOf(
                Validator.ValidationPair(inputEmail, ::isValidEmail),
                Validator.ValidationPair(inputPassword) { isValidMinLength(it, 6) }
            )
            enableButtonOnValidation(btnSignIn, validationPairs)

            btnSignIn.setOnClickListener {
                viewModel.login(
                    PostLoginModel(email = inputEmail.text.toString(), password = inputPassword.text.toString())
                )
            }
            tvForgotPasswod.setOnClickListener {
                findNavController().navigate(
                    R.id.action_signInFragment_to_forgotEmailFragment
                )
            }
        }
    }
    private fun updateUi(uiState: LoginUiState) {
        if (uiState.isLoading) {
            binding.btnSignIn.visibility = View.GONE
            binding.loadingState.visibility = View.VISIBLE
        }else{
            binding.btnSignIn.visibility = View.VISIBLE
            binding.loadingState.visibility = View.GONE
        }
        uiState.loginResult?.let { loginResult ->
        }
        uiState.apiError?.let { authError ->
            binding.edtPassword.error = authError.message
        }
    }
}