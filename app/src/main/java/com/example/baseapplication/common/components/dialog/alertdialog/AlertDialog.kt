package com.example.baseapplication.common.components.dialog.alertdialog

import android.content.Context
import android.widget.Button
import androidx.appcompat.widget.LinearLayoutCompat
import com.example.baseapplication.R
import com.example.baseapplication.common.components.dialog.BaseDialog
import com.example.baseapplication.common.utils.extension.core.getActivity
import com.example.baseapplication.databinding.LayoutAlertDialogBinding

class AlertDialog {
    class Builder(private val context: Context) : BaseDialog<LayoutAlertDialogBinding>(context) {

        private var title: String = context.getString(R.string.progress_title)
        private var message: String = context.getString(R.string.progress_text)
        private var positiveText: String = context.getString(R.string.ok)
        private var negativeText: String = context.getString(R.string.close)
        private var isHorizontal: Boolean = true
        private var alertDialogButtonSize = AlertDialogButtonSize.Message
        private var resourceImage = R.drawable.baseline_info_24

        private var negativeListener: () -> Unit = {
            hideDialog()
        }

        private var positiveListener: () -> Unit = {
            hideDialog()
        }

        fun setAlertDialogButtonType(alertDialogButtonSize: AlertDialogButtonSize) = apply {
            this.alertDialogButtonSize = alertDialogButtonSize
        }

        fun setButtonSize(
            alertDialogButtonSize: AlertDialogButtonSize,
            customButtons: List<AlertDialogCustomButton>
        ) {
            this.alertDialogButtonSize = alertDialogButtonSize
            this.customButtons = customButtons
        }

        fun setDrawable(drawableResource: Int) = apply {
            this.resourceImage = drawableResource
        }

        fun getDrawable(): Int {
            return resourceImage
        }

        fun setTitle(title: String) = apply {
            this.title = title
        }

        fun setTitle(titleResource: Int) = apply {
            title = context.getString(titleResource)
        }

        fun setMessage(message: String) = apply {
            this.message = message
        }

        fun setMessage(messageResource: Int) = apply {
            message = context.getString(messageResource)
        }

        fun getMessage(): String {
            return message
        }

        fun setPositiveText(positiveText: String) = apply {
            this.positiveText = positiveText
        }

        fun setPositiveText(positiveTextResource: Int) = apply {
            positiveText = context.getString(positiveTextResource)
        }

        fun getPositiveText(): String {
            return positiveText
        }

        fun setNegativeText(negativeText: String) = apply {
            this.negativeText = negativeText
        }

        fun setNegativeText(negativeTextResource: Int) = apply {
            negativeText = context.getString(negativeTextResource)
        }

        fun getNegativeText(): String? {
            return negativeText
        }

        fun setPositiveListener(positiveListener: () -> Unit) = apply {
            this.positiveListener = positiveListener
        }

        fun setPositiveListener(positiveText: String, positiveListener: () -> Unit) = apply {
            this.positiveText = positiveText
            this.positiveListener = positiveListener
        }

        fun setPositiveListener(positiveTextResource: Int, positiveListener: () -> Unit) = apply {
            this.positiveText = context.getString(positiveTextResource)
            this.positiveListener = positiveListener
        }

        fun setNegativeListener(negativeListener: () -> Unit) = apply {
            this.negativeListener = negativeListener
        }

        fun setNegativeListener(negativeText: String, negativeListener: () -> Unit) = apply {
            this.negativeText = negativeText
            this.negativeListener = negativeListener
        }

        fun setNegativeListener(negativeTextResource: Int, negativeListener: () -> Unit) = apply {
            this.negativeText = context.getString(negativeTextResource)
            this.negativeListener = negativeListener
        }

        fun changeCancelable(cancelable: Boolean) = apply {
            super.setCancelable(cancelable)
        }
        // buildera eklenecek


        private var customButtons = listOf<AlertDialogCustomButton>()
        // buildera eklenecek

        // build sonrası

        override fun initView() {
            binding?.apply {
                customTitle.text = title
                customText.text = message
                cutomDialogImage.setImageResource(resourceImage)

                customViewButtons.orientation = if (isHorizontal) {
                    LinearLayoutCompat.HORIZONTAL
                } else {
                    LinearLayoutCompat.VERTICAL
                }

                customButtons.forEach { item ->
                    val newButton = Button(context)
                    newButton.text = item.buttonText
                    newButton.setOnClickListener {
                        item.buttonAction.invoke()
                    }
                    customViewButtons.addView(newButton)
                }

            }

        }

        fun build() {
            customButtons = getButtons()
            initDialog()
            showDialog()
        }

        private fun getButtons() = when (alertDialogButtonSize) {
            AlertDialogButtonSize.Message -> {
                listOf(
                    AlertDialogCustomButton(negativeText, negativeListener)
                )
            }

            AlertDialogButtonSize.Question -> {
                listOf(
                    AlertDialogCustomButton(positiveText, positiveListener),
                    AlertDialogCustomButton(negativeText, negativeListener)
                )
            }

            else -> {
                customButtons
            }
        }


        override fun getViewBinding() = context.getActivity()?.layoutInflater?.let { inf ->
            LayoutAlertDialogBinding.inflate(inf)
        }


    }
}

enum class AlertDialogButtonSize {
    Message,
    Question,
    Custom
}