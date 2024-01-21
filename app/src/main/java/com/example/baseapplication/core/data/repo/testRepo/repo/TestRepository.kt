package com.example.baseapplication.core.data.repo.testRepo.repo

import com.example.baseapplication.common.utils.api.ApiResult
import com.example.baseapplication.core.data.repo.testRepo.data.response.TestResponse

interface TestRepository {

    suspend fun getUpcomingMovieList(): ApiResult<TestResponse>

}
