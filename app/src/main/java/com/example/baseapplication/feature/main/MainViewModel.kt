package com.example.baseapplication.feature.main

import androidx.lifecycle.viewModelScope
import com.example.baseapplication.common.base.BaseViewModel
import com.example.baseapplication.common.utils.api.onSuccess
import com.example.baseapplication.core.data.repo.testRepo.data.response.TestResponse
import com.example.baseapplication.core.domain.test.TestUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val testUseCase: TestUseCase) : BaseViewModel() {

    private val _testResponse = MutableSharedFlow<TestResponse>()
    val testResponse = _testResponse.asSharedFlow()

    fun startApi() = viewModelScope.launch {
        apiCall(
            call = {
                testUseCase.invoke()
            }
        ).onSuccess { uiModel ->
            uiModel.let { movieDetail ->
                _testResponse.emit(movieDetail)
            }
        }
    }
}