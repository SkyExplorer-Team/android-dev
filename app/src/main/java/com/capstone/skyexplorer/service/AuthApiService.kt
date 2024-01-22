package com.capstone.skyexplorer.service

import com.capstone.skyexplorer.model.auth.login.LoginResponse
import retrofit2.http.Field
import retrofit2.http.POST

interface AuthApiService {
    @POST("users/login")
    suspend fun login(
        @Field("email") email : String,
        @Field("password") password : String,
    ) : LoginResponse
}