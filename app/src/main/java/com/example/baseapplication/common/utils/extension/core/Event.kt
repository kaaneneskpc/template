package com.example.baseapplication.common.utils.extension.core

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

open class Event<out T>(private val content: T) {

	var hasBeenHandled = false
		private set

	/**
	 * Returns the content and prevents its use again.
	 */
	fun getContentIfNotHandled(): T? {
		return if (hasBeenHandled) {
			null
		} else {
			hasBeenHandled = true
			content
		}
	}

	/**
	 * Returns the content, even if it's already been handled.
	 */
	fun peekContent(): T = content
}

fun <T> LiveData<out Event<T>>.observeEvent(owner: LifecycleOwner, callback: (T) -> Unit) {
	observe(owner) { it?.getContentIfNotHandled()?.let(callback) }
}
