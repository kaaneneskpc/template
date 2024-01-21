package com.example.baseapplication.common.utils.extension.kotlin

import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.NumberFormat
import java.util.Locale

/** Ekran bileşenleri excelindeki kurallara göre:
* 1. Kuruşlar virgül ile, binlikler ise nokta ile ayrılmalıdır.
* 2. Tam sayıdan sonraki kısım virgül ile ayrılır; nokta ile değil.
* Virgülden sonra çift sıfırlı bir ifade kalıyorsa “,00” virgül ve sonrası dikkate alınmasın.
	Örnek: 252,00 şeklinde bir gösterim olmasın. Hep 252 tam sayı olsun.
	Örnek: 252,001 olduğu durumda da 252 tam sayı olsun
* 3. Virgülden sonra hep iki sayı gelir, 3. Ve sonraki basamaklar dikkate alınmaz.
	Örnek: 67,432 gibi bir sayı gelirse 67,43 olur
	Örnek: 67,437 gibi bir sayı gelirse 67,44 olur */

fun Double.roundDecimal(): String {
	val df = DecimalFormat("#.00")
	val sym: DecimalFormatSymbols = DecimalFormatSymbols.getInstance()
	sym.decimalSeparator = ','
	df.decimalFormatSymbols = sym
	return df.format(this).replace(",00", "")
}

fun Double.numberFormatTl(): String {
	return try {
		NumberFormat.getCurrencyInstance(Locale("tr", "TR"))
			.format(this)
			.replace("[,.]00$".toRegex(), "")
			.replace("₺".toRegex(), "")
	} catch (e: Exception) {
		""
	}
}

fun String.numberFormatTl(canFree: Boolean = false, freeText: String = ""): String {
	return try {
		val formatTl = if (this.contains(",")) {
			this.commaToDotValue().toDouble()
		} else {
			this.toDouble()
		}
		NumberFormat.getCurrencyInstance(Locale("tr", "TR"))
			.format(formatTl)
			.replace("[,.]00$".toRegex(), "")
			.replace("₺".toRegex(), "")
	} catch (e: Exception) {
		if (canFree) freeText else ""
	}
}

fun Double.toPercentValue(value: Double): Double {
	return if (this == 0.0) 0.0 else ((value / this) * 100).roundValue()
}

fun String.commaToDotValue() = this.replace(",", ".")
fun String.dotToCommaValue() = this.replace(".", ",")

fun Double.roundValue(): Double {
	val symbols = DecimalFormatSymbols(Locale.ROOT)
	val value = DecimalFormat("#.#", symbols).apply {
		roundingMode = RoundingMode.FLOOR
	}.run {
		format(this@roundValue)
	}
	return if (value.contains(",")) {
		value.commaToDotValue().toDouble()
	} else {
		value.toDouble()
	}
}