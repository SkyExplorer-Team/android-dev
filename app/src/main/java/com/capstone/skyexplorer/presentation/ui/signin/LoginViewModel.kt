package com.capstone.skyexplorer.presentation.ui.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.capstone.skyexplorer.model.auth.login.LoginResponse
import com.capstone.skyexplorer.model.auth.login.PostLoginModel
import com.capstone.skyexplorer.repository.AuthRepository
import com.capstone.skyexplorer.utils.ApiError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository : AuthRepository
): ViewModel(){
    private val _state = MutableStateFlow(LoginUiState())
    val state : StateFlow<LoginUiState> = _state

    fun login(data : PostLoginModel) {
        viewModelScope.launch {
            setError(null)
            setLoading(true)
            val result = repository.login(data)

            result.data?.let { response ->
                setResult(response)
                setLoading(false)
            }

            result.error?.let { authError ->
                setError(authError)
                setLoading(false)
            }
        }
    }

    private fun setLoading(value:Boolean){
        _state.update {
            it.copy(isLoading = value)
        }
    }
    private fun setError(apiError: ApiError?) {
        _state.value = _state.value.copy(apiError = apiError)
    }

    private fun setResult(value : LoginResponse){
        _state.update {
            it.copy(
                loginResult = value
            )
        }
    }
}