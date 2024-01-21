package com.example.baseapplication.common.utils.extension.kotlin

/**
 * Checks if given string is a valid msisdn
 */
fun String?.isMsisdnValid(): Boolean {
	if (isNullOrBlank()) return false

	if (all { it.isDigit() }.not()) return false

	return length == 10 && startsWith("5")
}

/**
 * Normalize given string to 10 digits msisdn "XXXXXXXXXX"
 */
fun String?.normalizeMsisdn(): String {
	if (isNullOrBlank()) return this ?: ""

	return replace("[^0-9]".toRegex(), "").takeLast(10)
}

/**
 * Format given string to following pattern if it is valid : "XXX XXX XX XX"
 */
fun String?.formatMsisdn(): String {
	val normalizedMsisdn = normalizeMsisdn()

	if (normalizedMsisdn.isMsisdnValid().not()) return this ?: ""

	val builder = StringBuilder(normalizedMsisdn)

	if (builder.length >= 9) builder.insert(8, " ")
	if (builder.length >= 7) builder.insert(6, " ")
	if (builder.length >= 4) builder.insert(3, " ")

	return builder.toString()
}