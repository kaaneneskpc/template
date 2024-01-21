package com.example.baseapplication.core.domain.test

import com.example.baseapplication.common.utils.extension.core.buildDefaultFlow
import com.example.baseapplication.common.utils.api.ApiResult
import com.example.baseapplication.core.data.repo.testRepo.data.response.TestResponse
import com.example.baseapplication.core.data.repo.testRepo.repo.TestRepository
import com.example.baseapplication.common.utils.qualifier.IoDispatcher
import com.example.baseapplication.core.domain.base.FlowUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class TestUseCase @Inject constructor(
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    private val publicRepository: TestRepository,
) {
    suspend operator fun invoke(): Flow<ApiResult<TestResponse>> = flow {
        val response = publicRepository.getUpcomingMovieList()
        emit(response)
    }.buildDefaultFlow(dispatcher)

}