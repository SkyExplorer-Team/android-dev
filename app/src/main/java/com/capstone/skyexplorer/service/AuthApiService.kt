package com.capstone.skyexplorer.service

import com.capstone.skyexplorer.model.auth.login.LoginResponse
import com.capstone.skyexplorer.model.auth.login.PostLoginModel
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import java.net.CacheRequest

interface AuthApiService {
    @POST("auth/login")
    suspend fun login(
        @Body loginData: PostLoginModel
    ) : LoginResponse
}