package com.capstone.skyexplorer.di.auth

import com.capstone.skyexplorer.service.AuthApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
@Module
@InstallIn(SingletonComponent::class)
class AuthNetworkModule {
    @Provides
    fun provideCategoryApiService(retrofit : Retrofit): AuthApiService {
        return retrofit.create(AuthApiService::class.java)
    }
}

