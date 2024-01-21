package com.example.baseapplication.common.utils.extension.core

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources

fun Context.getActivity(): Activity? {
    return when (this) {
        is Activity -> this
        is ContextWrapper -> this.baseContext.getActivity()
        else -> null
    }
}

fun Context.getDrawableCompat(@DrawableRes id: Int): Drawable? =
    AppCompatResources.getDrawable(this, id)