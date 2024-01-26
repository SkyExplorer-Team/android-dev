package com.capstone.skyexplorer.presentation.ui.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.capstone.skyexplorer.presentation.ui.signin.LoginUiState
import com.capstone.skyexplorer.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val repository : AuthRepository
): ViewModel(){
    private val _state = MutableStateFlow(OnBoardingUiState())
    val state : StateFlow<OnBoardingUiState> = _state
    fun setShowOnBoarding(isShow : Boolean){
        viewModelScope.launch {
            repository.setShowOnBoarding(isShow)
        }
    }
    fun getShowOnBoarding(){
        viewModelScope.launch {
            repository.getShowOnBoarding().collect{
                onBoardingState(it)
            }
        }
    }
    private fun onBoardingState(isShow: Boolean){
        _state.update {
            it.copy(
                showOnBoarding = isShow
            )
        }
    }
}