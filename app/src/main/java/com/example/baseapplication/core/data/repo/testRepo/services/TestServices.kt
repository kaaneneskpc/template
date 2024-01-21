package com.example.baseapplication.core.data.repo.testRepo.services


import com.example.baseapplication.common.utils.api.ApiResponse
import com.example.baseapplication.core.data.repo.testRepo.data.response.TestResponse
import retrofit2.Response
import retrofit2.http.GET

interface TestServices {
    @GET(TestEndPoint.TEST)
    suspend fun getUpcomingMovieList(): Response<ApiResponse<TestResponse>>
}
