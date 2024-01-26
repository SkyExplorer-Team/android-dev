package com.capstone.skyexplorer.utils

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException

object ErrorParser {
    fun parseErrorMessageFromJson(json: String?): String {
        return try {
            val gson = Gson()
            val errorResponse = gson.fromJson(json, ErrorResponse::class.java)
            errorResponse.message ?: "Pesan Kesalahan tidak ditemukan"
        } catch (e: JsonSyntaxException) {
            "Gagal mengurai kesalahan JSON"
        } catch (e: Exception) {
            "Terjadi kesalahan dalam parsing JSON"
        }
    }
    data class ErrorResponse(val message: String?)
}