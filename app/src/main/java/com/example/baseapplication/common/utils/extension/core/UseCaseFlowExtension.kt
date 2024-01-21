package com.example.baseapplication.common.utils.extension.core

import com.example.baseapplication.common.utils.api.ApiResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*


inline fun <reified T> Flow<ApiResult<T>>.buildDefaultFlow(
    dispatcher: CoroutineDispatcher
): Flow<ApiResult<T>> {
    return this.onStart {
        emit(ApiResult.Loading)
    }.catch { e ->
        emit(ApiResult.Error(e))
    }.flowOn(dispatcher)
}

suspend fun <T1, T2> combineResult(
    restResult: ApiResult<T1>,
    restResult2: ApiResult<T2>,
    transform: suspend (a: T1, b: T2) -> Unit
): List<ApiResult<Any?>> {
    val list = listOf(restResult, restResult2)
    if (list.any { it !is ApiResult.Success }.not()) {
        transform(
            (restResult as ApiResult.Success).result,
            (restResult2 as ApiResult.Success).result
        )
    }

    return list
}

suspend fun <T1, T2, T3> combineResult(
    restResult: ApiResult<T1>,
    restResult2: ApiResult<T2>,
    restResult3: ApiResult<T3>,
    transform: suspend (a: T1, b: T2, c: T3) -> Unit
): List<ApiResult<Any?>> {
    val list = listOf(restResult, restResult2, restResult3)
    if (list.any { it !is ApiResult.Success }.not()) {
        transform(
            (restResult as ApiResult.Success).result,
            (restResult2 as ApiResult.Success).result,
            (restResult3 as ApiResult.Success).result
        )
    }

    return list
}

suspend fun <T1, T2, T3, T4> combineResult(
    restResult: ApiResult<T1>,
    restResult2: ApiResult<T2>,
    restResult3: ApiResult<T3>,
    restResult4: ApiResult<T4>,
    transform: suspend (a: T1, b: T2, c: T3, d: T4) -> Unit
): List<ApiResult<Any?>> {
    val list = listOf(restResult, restResult2, restResult3, restResult4)
    if (list.any { it !is ApiResult.Success }.not()) {
        transform(
            (restResult as ApiResult.Success).result,
            (restResult2 as ApiResult.Success).result,
            (restResult3 as ApiResult.Success).result,
            (restResult4 as ApiResult.Success).result
        )
    }

    return list
}

suspend fun List<ApiResult<*>>.ifError(action: suspend (ApiResult.Error) -> Unit): List<ApiResult<Any?>> {
    filterIsInstance<ApiResult.Error>()
        .firstOrNull()
        ?.let { action(it) }

    return this
}

