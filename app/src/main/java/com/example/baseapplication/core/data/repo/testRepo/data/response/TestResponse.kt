package com.example.baseapplication.core.data.repo.testRepo.data.response

import com.google.gson.annotations.SerializedName

data class TestResponse(
    @SerializedName("test") val test: String,
    @SerializedName("test2") val test2: Int?
)