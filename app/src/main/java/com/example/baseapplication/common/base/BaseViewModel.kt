package com.example.baseapplication.common.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.baseapplication.common.utils.api.ApiResult
import com.example.baseapplication.common.utils.api.LoadingType
import com.example.baseapplication.common.utils.api.MessageType
import com.example.baseapplication.common.utils.extension.core.Event
import com.example.baseapplication.common.utils.extension.kotlin.applyIf
import com.example.baseapplication.common.utils.extension.kotlin.then
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

open class BaseViewModel : ViewModel() {

    private val _progress = MutableStateFlow(false)
    val progress = _progress.asStateFlow()

    private val _showMessage = MutableSharedFlow<Event<BaseDialogHandler>>()
    val showMessage = _showMessage.asSharedFlow()

    private var loadingCount = 0

    suspend fun <T : Any> apiCall(
        loadingType: LoadingType = LoadingType.DEFAULT,
        errorMessageType: MessageType = MessageType.DIALOG,
        successMessageType: MessageType = MessageType.NONE,
        call: suspend () -> Flow<ApiResult<T>>
    ): ApiResult<T> = suspendCoroutine { continuation ->
        viewModelScope.launch {
            call.invoke().collect { apiResult ->
                when (apiResult) {
                    is ApiResult.Loading -> {
                        startProgress(loadingType)
                    }

                    is ApiResult.Success -> {
                        closeProgress(loadingType)
                        showDialog(
                            BaseDialogHandler(
                                apiResult.message,
                                successMessageType,
                                BaseDialogHandler.DialogType.Success
                            )
                        )
                        continuation.resume(apiResult)
                    }

                    is ApiResult.Error -> {
                        closeProgress(loadingType)
                        showDialog(
                            BaseDialogHandler(
                                apiResult.exception.message,// istek hatası olduğu için bir hata meydana geldi setlenebilir
                                errorMessageType,
                                BaseDialogHandler.DialogType.Error
                            )
                        )
                        continuation.resume(apiResult)
                    }

                    is ApiResult.Failure -> {
                        closeProgress(loadingType)
                        showDialog(
                            BaseDialogHandler(
                                apiResult.message,
                                errorMessageType,
                                BaseDialogHandler.DialogType.Error
                            )
                        )
                        continuation.resume(apiResult)
                    }

                    else -> {
                        //no*op
                    }
                }
            }
        }
    }

    private suspend fun showDialog(dialogHandler: BaseDialogHandler) =
        applyIf(dialogHandler.isShow()) {
            _showMessage.emit(Event(dialogHandler))
        }

    private fun startProgress(loadingType: LoadingType) = (loadingType != LoadingType.NONE).then {
        loadingCount++
        if (loadingCount > 0) {
            _progress.value = true
        }
    }

    private fun closeProgress(loadingType: LoadingType) = (loadingType != LoadingType.NONE).then {
        loadingCount--
        if (loadingCount == 0) {
            _progress.value = false
        }
    }
}

