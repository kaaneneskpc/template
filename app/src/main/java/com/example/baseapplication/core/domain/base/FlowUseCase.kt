package com.example.baseapplication.core.domain.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import com.example.baseapplication.common.utils.api.ApiResult

/**
 * Executes business logic in its execute method and keep posting updates to the result as
 * [Result<R>].
 */
abstract class FlowUseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher) {
    suspend operator fun invoke(param: P): Flow<ApiResult<R>> = execute(param)
        .flowOn(coroutineDispatcher)

    protected abstract suspend fun execute(param: P): Flow<ApiResult<R>>
}