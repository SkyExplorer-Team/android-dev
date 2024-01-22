package com.capstone.skyexplorer.presentation.ui.signin

import com.capstone.skyexplorer.model.auth.login.LoginResponse

data class LoginUiState (
    val isLoading : Boolean = false,
    val isError : Boolean = false,
    val loginResult : LoginResponse? = null
)