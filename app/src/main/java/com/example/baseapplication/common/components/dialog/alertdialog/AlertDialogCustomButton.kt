package com.example.baseapplication.common.components.dialog.alertdialog

data class AlertDialogCustomButton(
    val buttonText: String,
    val buttonAction: () -> Unit
)