package com.example.baseapplication.common.components.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.DisplayMetrics
import android.view.Gravity
import android.view.WindowManager
import androidx.viewbinding.ViewBinding
import com.example.baseapplication.common.utils.extension.core.getActivity
import com.example.baseapplication.common.utils.extension.kotlin.isNotNull
import com.example.baseapplication.common.utils.extension.kotlin.orFalse
import timber.log.Timber

abstract class BaseDialog<VB : ViewBinding?>(
    private var context: Context
) {

    private var dialog: Dialog? = null

    private var width = 0

    private var height = 0

    private var mCancelable = false

    var isHidden = false

    protected abstract fun initView()

    protected var binding: VB? = null
    abstract fun getViewBinding(): VB?

    fun showDialog() {
        isHidden = false
        try {
            val activity = context.getActivity()
            if (dialog.isNotNull() && activity.isNotNull() && !activity?.isFinishing.orFalse())
                dialogShowProcess()
        } catch (e: WindowManager.BadTokenException) {
            Timber.i("hide dialog", "illegal")
        }
    }

    fun hideDialog() {
        isHidden = true
        try {
            val activity = context.getActivity()
            if (dialog.isNotNull() && activity.isNotNull()) {
                dialogShowProcess()
            }
        } catch (e: WindowManager.BadTokenException) {
            Timber.i("hide dialog", "illegal")
        } catch (e: IllegalArgumentException) {
            Timber.i("hide dialog", "illegal")
        }
    }

    internal fun setCancelable(cancelable: Boolean) {
        mCancelable = cancelable
    }

    private fun dialogShowProcess() {
        dialog?.apply {
            if (isHidden) {
                dialog?.dismiss()
            } else {
                dialog?.show()
                afterShow()
            }

        }
    }

    private fun afterShow() {
        dialog?.apply {
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            window?.attributes?.gravity= Gravity.CENTER

            val metrics: DisplayMetrics = context.resources.displayMetrics
            val width: Int = metrics.widthPixels

            val lp = WindowManager.LayoutParams()
            lp.copyFrom(window?.attributes)
            lp.width = 6 * width / 7
            window?.attributes = lp
        }
    }

    fun initDialog() {
        dialog = Dialog(context)
        dialog?.apply {
            binding = getViewBinding()
            binding?.root?.let { setContentView(it) }
            initView()
        }
    }

    public fun getDialog() = dialog
}