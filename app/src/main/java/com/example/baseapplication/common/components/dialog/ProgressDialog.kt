package com.example.baseapplication.common.components.dialog

import android.content.Context
import com.example.baseapplication.common.utils.extension.core.getActivity
import com.example.baseapplication.databinding.FragmentLoadingDilaogBinding

class ProgressDialog(private val context: Context) :
    BaseDialog<FragmentLoadingDilaogBinding>(context) {

    override fun initView() {}

    override fun getViewBinding() = context.getActivity()?.layoutInflater?.let { inf ->
        FragmentLoadingDilaogBinding.inflate(inf)
    }

    init {
        initDialog()
    }

    public fun show(isShow: Boolean) = if (isShow) {
        showDialog()
    } else {
        hideDialog()
    }
}
