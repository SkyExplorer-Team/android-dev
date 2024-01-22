package com.capstone.skyexplorer.model.auth.login

import com.google.gson.annotations.SerializedName

data class LoginDataResponse(
    @field:SerializedName("token")
    val token : String,
    @field:SerializedName("type")
    val type : String,
    @field:SerializedName("email")
    val email : String,
    @SerializedName("role")
    val role: String
)