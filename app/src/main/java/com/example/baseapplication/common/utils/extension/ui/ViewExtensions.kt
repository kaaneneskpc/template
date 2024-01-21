package com.example.baseapplication.common.utils.extension.ui

import android.content.Context
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.core.view.marginBottom
import androidx.core.view.marginLeft
import androidx.core.view.marginRight
import androidx.core.view.marginTop
import com.google.android.material.floatingactionbutton.FloatingActionButton

fun View.setMargins(
    marginLeft: Int = this.marginLeft,
    marginTop: Int = this.marginTop,
    marginRight: Int = this.marginRight,
    marginBottom: Int = this.marginBottom,
) {
    if (layoutParams is ViewGroup.MarginLayoutParams) {
        (layoutParams as ViewGroup.MarginLayoutParams).setMargins(
            toDP(marginLeft),
            toDP(marginTop),
            toDP(marginRight),
            toDP(marginBottom)
        )
        requestLayout()
    }
}

fun View.setPaddings(
    paddingLeft: Int = this.paddingLeft,
    paddingTop: Int = this.paddingTop,
    paddingRight: Int = this.paddingRight,
    paddingBottom: Int = this.paddingBottom,
) = setPadding(toDP(paddingLeft), toDP(paddingTop), toDP(paddingRight), toDP(paddingBottom))

//region Visibility Functions
fun View.visible() {
    visibility = View.VISIBLE
}

fun View.reverseVisibility() {
    visibility = if (isVisible) View.GONE else View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.reverseInvisibility() {
    visibility = if (isInvisible) View.VISIBLE else View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}
//endregion

//region Enable Functions
fun View.enable() {
    isEnabled = true
}

fun View.disable() {
    isEnabled = false
}

fun View.reverseEnabling() {
    isEnabled = !isEnabled
}
//endregion

//region Conversion Functions
fun View.toDP(pixel: Int): Int = this.toDP(pixel.toFloat())

fun View.toDP(pixel: Float): Int =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, pixel, resources.displayMetrics).toInt()

fun View.toSP(value: Int): Float = this.toSP(value.toFloat())

fun View.toSP(value: Float): Float =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, value, resources.displayMetrics)

fun Context.toDp(value: Int) = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP,
    value.toFloat(),
    resources.displayMetrics
).toInt()

fun Context.toSp(value: Int) =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, value.toFloat(), resources.displayMetrics)
        .toInt()

fun Context.toPx(value: Int) =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, value.toFloat(), resources.displayMetrics)
        .toInt()

//endregion

fun View.crossFadeAnimation(defaultDuration: Int = 500) {
    val animationAlpha = AlphaAnimation(0f, 1f).apply {
        duration = defaultDuration.toLong()
    }
    startAnimation(animationAlpha)
}