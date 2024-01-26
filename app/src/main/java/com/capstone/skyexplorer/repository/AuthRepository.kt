package com.capstone.skyexplorer.repository

import android.util.Log
import com.capstone.skyexplorer.model.auth.login.LoginResponse
import com.capstone.skyexplorer.model.auth.login.PostLoginModel
import com.capstone.skyexplorer.pref.ApplicationPreferences
import com.capstone.skyexplorer.service.AuthApiService
import com.capstone.skyexplorer.utils.ApiError
import com.capstone.skyexplorer.utils.ApiErrorType
import com.capstone.skyexplorer.utils.ApiResult
import com.capstone.skyexplorer.utils.ErrorParser
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val authApiService: AuthApiService,
    private val applicationPreferences: ApplicationPreferences
) {
    suspend fun login(data: PostLoginModel): ApiResult<LoginResponse> {
        return try {
            val response = authApiService.login(loginData = data)
            ApiResult(data = response)
        } catch (e: IOException) {
            ApiResult(error = ApiError(ApiErrorType.NETWORK_ERROR, "Terjadi kesalahan jaringan"))
        } catch (e: HttpException) {
            val errorJson = e.response()?.errorBody()?.string()
            val errorMessage = ErrorParser.parseErrorMessageFromJson(errorJson)
            ApiResult(error = ApiError(ApiErrorType.HTTP_ERROR, errorMessage))
        } catch (e: JsonSyntaxException) {
            ApiResult(error = ApiError(ApiErrorType.JSON_PARSE_ERROR, "Gagal mengurai kesalahan JSON"))
        } catch (e: Exception) {
            ApiResult(error = ApiError(ApiErrorType.OTHER_ERROR, "Terjadi kesalahan"))
        }
    }

    suspend fun setShowOnBoarding(data : Boolean){
        applicationPreferences.setShowOnboarding(data)
    }
    fun getShowOnBoarding(): Flow<Boolean> = applicationPreferences.getShowOnBoarding()

}