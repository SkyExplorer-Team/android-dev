package com.capstone.skyexplorer.presentation.ui.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.capstone.skyexplorer.model.auth.login.LoginResponse
import com.capstone.skyexplorer.model.auth.login.PostLoginModel
import com.capstone.skyexplorer.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository : AuthRepository
): ViewModel(){
    private val _state = MutableStateFlow(LoginUiState())
    val state : StateFlow<LoginUiState> = _state

    fun login(data : PostLoginModel) {
        viewModelScope.launch {
            setError(false)
            setLoading(true)
            repository.login(data).collect{ result ->
                setLoading(false)
                result.onSuccess {
                    setResult(it)
                }
                result.onFailure {
                    setError(true)
                }
            }
        }
    }

    private fun setLoading(value:Boolean){
        _state.update {
            it.copy(isLoading = value)
        }
    }
    private fun setError(value:Boolean){
        _state.update {
            it.copy(isError = value)
        }
    }

    private fun setResult(value : LoginResponse){
        _state.update {
            it.copy(
                loginResult = value
            )
        }
    }
}