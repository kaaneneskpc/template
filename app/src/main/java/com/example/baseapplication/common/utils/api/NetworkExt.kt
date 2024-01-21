package com.example.baseapplication.common.utils.api


import com.example.baseapplication.common.utils.extension.kotlin.orFalse
import com.google.gson.Gson
import okhttp3.ResponseBody
import retrofit2.HttpException
import retrofit2.Response

inline val <T> Response<ApiResponse<T>>.asApiResult: ApiResult<T>
    get() {
        when {
            isSuccessful -> {
                return (body()?.let { safeBody ->
                    if (safeBody.isSuccess.orFalse()) {
                        ApiResult.Success(
                            result = safeBody.data,
                            message = safeBody.message.orEmpty(),
                            statusCode = this.code()
                        )
                    } else {
                        ApiResult.Failure(
                            exception = HttpException(this),
                            message = safeBody.message,
                            statusCode = this.code()
                        )
                    }
                } ?: createErrorResult(this)) as ApiResult<T>
            }

            code() == HttpStatus.UNAUTHORIZED -> {
                return createErrorResult(this)
            }

            else -> {
                return createErrorResultWithErrorBody(this, this.errorBody())
            }
        }
    }

inline val <T> Response<T>.asSimpleApiResult: ApiResult<T>
    get() {
        when {
            this.isSuccessful -> {
                return body()?.let { body ->
                    ApiResult.Success(
                        result = body,
                        statusCode = this.code()
                    )
                } ?: createErrorResult(this)
            }

            code() == HttpStatus.UNAUTHORIZED -> {
                return createErrorResult(this)
            }

            else -> {
                return createErrorResultWithErrorBody(this, this.errorBody())
            }
        }
    }

fun <T> createErrorResultWithErrorBody(
    response: Response<T>,
    errorBody: ResponseBody?
): ApiResult.Error {
    errorBody?.let { body ->
        val errorBodyJsonString = body.string()

        runCatching {

            val errorApiResponseModel =
                Gson().fromJson(errorBodyJsonString, ApiResponse::class.java)

            if (errorApiResponseModel?.message != null) {
                return ApiResult.Error(
                    errorApiModel = errorApiResponseModel,
                    errorApiModelType = ErrorApiModelType.API,
                    statusCode = response.code()
                )
            }

        }
    }

    return createErrorResult(response)
}

fun <T> createRedirectionError(
    response: Response<T>
) = ApiResult.Failure(
    exception = HttpException(response),
    statusCode = response.code()
)

fun <T> createErrorResult(
    response: Response<T>
): ApiResult.Error {
    return ApiResult.Error(
        exception = HttpException(response),
        statusCode = response.code()
    )
}

