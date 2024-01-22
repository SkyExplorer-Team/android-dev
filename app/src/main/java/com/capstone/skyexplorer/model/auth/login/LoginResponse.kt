package com.capstone.skyexplorer.model.auth.login

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @field:SerializedName("result")
    val result: String,
    @field:SerializedName("data")
    val data : LoginDataResponse,
    @SerializedName("status")
    val status: String,
)

