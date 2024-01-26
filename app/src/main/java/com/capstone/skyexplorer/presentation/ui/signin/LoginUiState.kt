package com.capstone.skyexplorer.presentation.ui.signin

import com.capstone.skyexplorer.model.auth.login.LoginResponse
import com.capstone.skyexplorer.utils.ApiError

data class LoginUiState (
    val isLoading : Boolean = false,
    val isError : Boolean = false,
    val loginResult : LoginResponse? = null,
    val errorMessage: String? = null,
    val apiError : ApiError? = null
)