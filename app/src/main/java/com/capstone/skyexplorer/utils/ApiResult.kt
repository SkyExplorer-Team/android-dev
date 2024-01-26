package com.capstone.skyexplorer.utils

data class ApiResult<out T>(
    val data: T? = null,
    val error: ApiError? = null
)

data class ApiError(
    val type: ApiErrorType,
    val message: String
)

enum class ApiErrorType {
    NETWORK_ERROR,
    JSON_PARSE_ERROR,
    OTHER_ERROR,
    HTTP_ERROR,
}