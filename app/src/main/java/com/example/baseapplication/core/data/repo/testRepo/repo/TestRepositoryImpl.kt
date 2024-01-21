package com.example.baseapplication.core.data.repo.testRepo.repo

import com.example.baseapplication.common.utils.api.ApiResult
import com.example.baseapplication.core.data.repo.BaseApiRepository
import com.example.baseapplication.core.data.repo.testRepo.data.response.TestResponse
import com.example.baseapplication.core.data.repo.testRepo.services.TestServices
import javax.inject.Inject

class TestRepositoryImpl @Inject constructor(
    private val publicApiService: TestServices,
) : BaseApiRepository(), TestRepository {

    override suspend fun getUpcomingMovieList(): ApiResult<TestResponse> = request {
        publicApiService.getUpcomingMovieList()
    }

}

