package com.example.baseapplication.core.data.repo


import com.example.baseapplication.common.utils.api.asApiResult
import com.example.baseapplication.common.utils.api.asSimpleApiResult
import com.example.baseapplication.common.utils.api.ApiResponse
import com.example.baseapplication.common.utils.api.ApiResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

open class BaseApiRepository {


    suspend fun <T> request(
        call: suspend () -> Response<ApiResponse<T>>
    ): ApiResult<T> = withContext(Dispatchers.IO) {
        runCatching {
            call.invoke().asApiResult
        }.getOrElse { exception ->
            ApiResult.Error(exception)
        }
    }

    suspend fun <T> simpleRequest(
        call: suspend () -> Response<T>
    ): ApiResult<T> = withContext(Dispatchers.IO) {
        runCatching {
            call.invoke().asSimpleApiResult
        }.getOrElse { exception ->
            ApiResult.Error(exception)
        }
    }
}
