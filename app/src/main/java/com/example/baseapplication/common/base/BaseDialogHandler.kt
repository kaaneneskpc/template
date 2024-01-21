package com.example.baseapplication.common.base

import androidx.fragment.app.Fragment
import com.example.baseapplication.common.components.dialog.alertdialog.showSuccessMessage
import com.example.baseapplication.common.components.dialog.alertdialog.showWarningMessage
import com.example.baseapplication.common.utils.api.MessageType

class BaseDialogHandler(
    private val text: String?,
    private val errorMessageType: MessageType,
    private val dialogType: DialogType
) {

    fun showMessage(fragment: Fragment) = with(fragment) {
        when (errorMessageType) {
            MessageType.DIALOG -> {
                if (dialogType == DialogType.Success) {
                    showSuccessMessage(text.orEmpty())
                } else {
                    showWarningMessage(text.orEmpty())
                }
            }

            MessageType.SNACK_BAR -> {

            }

            MessageType.BOTTOM_SHEET -> {

            }

            else -> {}
        }
    }

    fun isShow() = errorMessageType != MessageType.NONE

    enum class DialogType {
        Error,
        Success
    }
}