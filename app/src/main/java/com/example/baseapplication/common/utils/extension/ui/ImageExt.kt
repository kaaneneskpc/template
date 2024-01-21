package com.example.baseapplication.common.utils.extension.ui

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadFromUrl(
    url: String? = "",
    defaultHolder: Int,
) {
    val requestBuilder = Glide.with(this.context).setDefaultRequestOptions(
        RequestOptions()
            .placeholder(defaultHolder)
            .error(defaultHolder)
    ).load(url)

    requestBuilder.into(this@loadFromUrl)
}