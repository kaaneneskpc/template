package com.example.baseapplication.common.components.dialog.alertdialog

import android.app.Activity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import com.example.baseapplication.R


fun Fragment.showWarningMessage(
    message: String,
    title: String = getString(R.string.warning),
    cancelable: Boolean = false,
    positiveText: String = getString(R.string.ok),
    onPositiveClick: () -> Unit = {},
) {
    AlertDialog.Builder(requireActivity())
        .setDrawable(R.drawable.baseline_info_24)
        .setTitle(title)
        .setMessage(message)
        .setPositiveListener(positiveText) {
            onPositiveClick.invoke()
        }
        .changeCancelable(cancelable)
        .build()
}

fun Fragment.showSuccessMessage(
    message: String,
    title: String = getString(R.string.success),
    cancelable: Boolean = false,
    positiveText: String = getString(R.string.ok),
    onPositiveClick: () -> Unit = {},
) {
    AlertDialog.Builder(requireActivity())
        .setDrawable(R.drawable.baseline_question_mark_24)
        .setTitle(title)
        .setMessage(message)
        .changeCancelable(cancelable)
        .setPositiveListener(positiveText) {
            onPositiveClick.invoke()
        }.build()
}


fun Fragment.showQuestionMessage(
    message: String,
    title: String = getString(R.string.process_success),
    cancelable: Boolean = false,
    onPositiveClick: () -> Unit = {},
    onNegativeClick: () -> Unit = {},
    negativeText: String = getString(R.string.cancel),
    positiveText: String = getString(R.string.confirm),
    icon: Int = R.drawable.baseline_question_mark_24,
) {
    AlertDialog.Builder(requireActivity())
        .setDrawable(icon)
        .setTitle(title)
        .setAlertDialogButtonType(AlertDialogButtonSize.Question)
        .setMessage(message)
        .setNegativeListener(negativeText) {
            onNegativeClick.invoke()
        }
        .setPositiveListener(positiveText) {
            onPositiveClick.invoke()
        }
        .changeCancelable(cancelable)
        .build()
}
