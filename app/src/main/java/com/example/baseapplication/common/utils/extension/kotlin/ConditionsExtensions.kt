package com.example.baseapplication.common.utils.extension.kotlin

/**
 * if sorgusu yerine kullanım için
 * @param condition sorgu
 * @param block sorgu karşılanırsa geri çalışıacak func
 */
inline fun <T> T.applyIf(condition: Boolean, block: T.() -> Unit): T {
	return if (condition) {
		this.apply(block)
	} else {
		this
	}
}

/**
 * string null değilse çalışsın
 * @param block string null değil ise çalışır
 */
inline fun String?.ifNotNullOrEmpty(crossinline block: (String) -> Unit) {
	if (this.isNotNullOrEmpty()) {
		block(this!!)
	}
}

/**
 * string null ise çalışsın
 * @param block string null ise çalışır
 */
inline fun String?.ifNullOrEmpty(crossinline block: () -> Unit) {
	if (this.isNullOrEmpty()) {
		block()
	}
}

/**
 *
 * Kullanım:
 * val condition = true
 * condition then { print("Some Message") } elze { print("Some other message") }
 * condition.then { print("Some Message") }.elze { print("Some other message") }
 **/
infix fun Boolean.then(action: () -> Unit): Boolean {
	if (this) {
		action.invoke()
	}
	return this
}

infix fun Boolean.elze(action: () -> Unit): Boolean {
	if (!this) {
		action.invoke()
	}
	return this
}

fun test (){
}