package com.example.baseapplication.common.utils.extension.core

import android.os.Build

/**
 * api versiyonunu kontrol eder
 * @param api api versiyonu
 * @param included dahil mi
 * @param block eğer api versiyonu güncel versiyondan yüksek ise
 */
inline fun belowApi(api: Int, included: Boolean = false, block: () -> Unit) {
	if (Build.VERSION.SDK_INT < if (included) api + 1 else api) {
		block()
	}
}

/**
 * api versiyonunu kontrol eder
 * @param api api versiyonu
 * @param included dahil mi
 * @param block eğer api versiyonu güncel versiyondan az ise
 */
inline fun aboveApi(api: Int, included: Boolean = false, block: () -> Unit) {
	if (Build.VERSION.SDK_INT > if (included) api - 1 else api) {
		block()
	}
}