package com.capstone.skyexplorer.repository

import android.util.Log
import com.capstone.skyexplorer.model.auth.login.LoginResponse
import com.capstone.skyexplorer.model.auth.login.PostLoginModel
import com.capstone.skyexplorer.pref.ApplicationPreferences
import com.capstone.skyexplorer.service.AuthApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val authApiService: AuthApiService,
    private val applicationPreferences: ApplicationPreferences
) {
    suspend fun login(data : PostLoginModel): Flow<Result<LoginResponse>> = flow {
        try {
            val response = authApiService.login(loginData = data)
            emit(Result.success(response))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Result.failure(e))
        }
    }.flowOn(Dispatchers.IO)
    suspend fun setShowOnBoarding(data : Boolean){
        applicationPreferences.setShowOnboarding(data)
    }
    fun getShowOnBoarding(): Flow<Boolean> = applicationPreferences.getShowOnBoarding()
}