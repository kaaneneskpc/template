package com.example.baseapplication.common.utils.api

import com.google.gson.annotations.SerializedName

class ApiResponse<out T>(
    @SerializedName("success")
    val isSuccess: Boolean?,
    @SerializedName("data")
    val data: T?,
    @SerializedName("status_message")
    val message: String?,
    @SerializedName("status_code")
    val code: Long?,
)
