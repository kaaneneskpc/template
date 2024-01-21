package com.example.baseapplication.common.utils.extension.kotlin

import android.text.format.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object DateHelper {

    /**
     * Transform Date String
     * dd.MM.yyyy -> yyyy-MM-dd
     * dd/MM/yyyy -> yyyy-MM-dd
     * dd.MM.yyyy  -> yyyy-MM-dd
     */
    fun formatDate(date: String,format:String): String {
        return try {

            val birthDate = SimpleDateFormat(format, Locale.getDefault()).parse(date)
            val calendar = Calendar.getInstance().apply { time = birthDate!! }
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH) + 1
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            "$year-$month-$day"
        } catch (e: Exception) {
            "-"
        }
    }
    /**
     * Transform Date String
     * dd/MM/yyyy -> yyyy-MM-dd
     */
    fun formatDateF(date: String): String {
        return try {
            val birthDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).parse(date)
            val calendar = Calendar.getInstance().apply { time = birthDate!! }
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH) + 1
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            "$year-$month-$day"
        } catch (e: Exception) {
            "-"
        }
    }
    /**
     * Transform Date String
     * dd.MM.yyyy -> yyyy-MM-dd
     */
    fun formatDateTime(date: String): String {
        return try {
            val birthDate = SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault()).parse(date)
            val calendar = Calendar.getInstance().apply { time = birthDate!! }
            val year = calendar.get(Calendar.YEAR)
            val month = String.format("%02d", calendar.get(Calendar.MONTH) + 1)
            val day = String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH))
            val hour = String.format("%02d", calendar.get(Calendar.HOUR))
            val min = String.format("%02d", calendar.get(Calendar.MINUTE))
            "$year-$month-$day $hour:$min"
        } catch (e: Exception) {
            "-"
        }
    }

    /**
     * Transform Date String
     * dd.MM.yyyy -> yyyy-MM-dd
     */
    fun formatServerDateTimeLocal(date: String): String {
        return try {
            val date = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(date)
            val calendar = Calendar.getInstance().apply { time = date!! }
            val year = calendar.get(Calendar.YEAR)
            val month = String.format("%02d", calendar.get(Calendar.MONTH) + 1)
            val day = String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH))
            val hour = String.format("%02d", calendar.get(Calendar.HOUR))
            val min = String.format("%02d", calendar.get(Calendar.MINUTE))
            "$day.$month.$year $hour:$min"
        } catch (e: Exception) {
            "-"
        }
    }

    /**
     * Format Date formatted in yyyy-MM-dd'T'HH:mm:ss.SSSSSS
     */
    fun getDate(date: String): Date {
        return try {
            SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS", Locale.getDefault()).parse(date)!!
        } catch (e: ParseException) {
            SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault()).parse(date)!!
        }
    }
     fun formatServeDateTimeLocal(date: String): String {

        return try {
            val date1 =
                SimpleDateFormat("yyyyMMdd", Locale.getDefault())
            val calendar = Calendar.getInstance().apply {
                time = this.time
            }
            val year = calendar.get(Calendar.YEAR)
            val month = String.format("%02d", calendar.get(Calendar.MONTH) + 1)
            val day = String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH))
            val dateNow = "$year$month$day"

            val start = date1.parse(dateNow)
            val end = date1.parse(date)
            val difference: Long? = end?.time?.let {
                start?.time?.minus(it)?.let {
                    kotlin.math.abs(
                        it
                    )
                }
            }
            val differenceDates = difference?.div((24 * 60 * 60 * 1000))
            val dayDifference = differenceDates.toString()
            dayDifference
        } catch (e: java.lang.Exception) {
            "-"
        }
    }

    fun formatServeDateTimeLocalDiff(date: String): Boolean {

        return try {
            val date1 =
                SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
            val calendar = Calendar.getInstance().apply {
                time = this.time
            }
            val start = calendar.time.time
            val end = date1.parse(date)?.time!!
            start > end
        } catch (e: java.lang.Exception) {
            false
        }
    }

    /**
     * Format Date formatted in yyyy-MM-dd'T'HH:mm:ss
     */
    fun formatGetDateTimeString(date: String): String {
        return try {
            val dateString =
                SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault()).parse(date)
            val calendar = Calendar.getInstance().apply { time = dateString!! }
            val year = String.format("%02d", calendar.get(Calendar.YEAR))
            val month = String.format("%02d", calendar.get(Calendar.MONTH) + 1)
            val day = String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH))
            val hour = String.format("%02d", calendar.get(Calendar.HOUR_OF_DAY))
            val min = String.format("%02d", calendar.get(Calendar.MINUTE))
            "$day.$month.$year"
        } catch (e: Exception) {
            "-"
        }
    }

    /**
     * Format Date formatted in yyyy-MM-dd'T'HH:mm:ss
     */
    fun formatDateString(date: String): String {
        return try {
            val dateString =
                SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault()).parse(date)
            val calendar = Calendar.getInstance().apply { time = dateString!! }
            val year = String.format("%02d", calendar.get(Calendar.YEAR))
            val month = String.format("%02d", calendar.get(Calendar.MONTH) + 1)
            val day = String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH))
            val hour = String.format("%02d", calendar.get(Calendar.HOUR_OF_DAY))
            val min = String.format("%02d", calendar.get(Calendar.MINUTE))
            "$day.$month.$year $hour:$min"
        } catch (e: Exception) {
            "-"
        }
    }
    /**
     * Format Date formatted in MM/dd/yyyy HH:mm:ss
     */
    fun formatGetDateTimeString2(date: String): String {
        return try {
            val dateString =
                SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.getDefault()).parse(date)
            val calendar = Calendar.getInstance().apply { time = dateString!! }
            val year = calendar.get(Calendar.YEAR)
            val month = String.format("%02d", calendar.get(Calendar.MONTH) + 1)
            val day = String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH))
            val hour = String.format("%02d", calendar.get(Calendar.HOUR_OF_DAY))
            val min = String.format("%02d", calendar.get(Calendar.MINUTE))
            "$day.$month.$year"
        } catch (e: Exception) {
            "-"
        }
    }

    /**
     * Format Date formatted in yyyy/MM/dd HH:mm
     */
    fun formatGetDateTimeString3(date: String): String {
        return try {
            val dateString =
                SimpleDateFormat("yyyy.MM.dd HH:mm", Locale.getDefault()).parse(date)
            val calendar = Calendar.getInstance().apply { time = dateString!! }
            val year = calendar.get(Calendar.YEAR)
            val month = String.format("%02d", calendar.get(Calendar.MONTH) + 1)
            val day = String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH))
            val hour = String.format("%02d", calendar.get(Calendar.HOUR_OF_DAY))
            val min = String.format("%02d", calendar.get(Calendar.MINUTE))
            "$day.$month.$year $hour:$min"
        } catch (e: Exception) {
            "-"
        }
    }

    /**
     * Format Date formatted in yyyy-MM-dd'T'HH:mm:ss.SSS
     */
    fun formatGetDateString(dateValue: String): String {
        return try {
            val date =
                SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(dateValue)
            val calendar = Calendar.getInstance().apply { time = date!! }
            val year = calendar.get(Calendar.YEAR)
            val month = String.format("%02d", calendar.get(Calendar.MONTH) + 1)
            val day = String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH))
            "$day.$month.$year"
        } catch (e: Exception) {
            "-"
        }
    }

    fun formatServerUTCTime(date: String): String {
        return try {
            val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault()).parse(date)
            val calendar = Calendar.getInstance().apply { time = date!! }
            val year = calendar.get(Calendar.YEAR)
            val month = String.format("%02d", calendar.get(Calendar.MONTH) + 1)
            val day = String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH))
            val hour = String.format("%02d", calendar.get(Calendar.HOUR))
            val min = String.format("%02d", calendar.get(Calendar.MINUTE))
            "$hour:$min"
        } catch (e: Exception) {
            "-"
        }
    }

    fun formatGetDay(date: String): String {
        return try {
            val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault()).parse(date)
            val calendar = Calendar.getInstance().apply { time = date!! }
            String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH))
        } catch (e: Exception) {
            "-"
        }
    }

    fun formatGetMonthName(date: String): String {
        return try {
            val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault()).parse(date)
            DateFormat.format("MMMM", date).toString()
        } catch (e: Exception) {
            "-"
        }
    }

    fun formatGetYear(date: String): String {
        return try {
            val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault()).parse(date)
            val calendar = Calendar.getInstance().apply { time = date!! }
            calendar.get(Calendar.YEAR).toString()
        } catch (e: Exception) {
            "-"
        }
    }

    fun formatGetTime(date: String): String {
        return try {
            val date =
                SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault()).parse(date)
            val calendar = Calendar.getInstance().apply {
                time = date!!
            }
            val hour = String.format("%02d", calendar.get(Calendar.HOUR_OF_DAY))
            val min = String.format("%02d", calendar.get(Calendar.MINUTE))
            return "$hour:$min"
        } catch (e: Exception) {
            "-"
        }
    }

    fun getCurrentDate(diff: Int = 0): String {
        return try {
            val calendar = Calendar.getInstance()
            calendar.add(Calendar.DAY_OF_YEAR, -diff)
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

            return "$year${month.plus(1)}$dayOfMonth"
        } catch (e: Exception) {
            "-"
        }
    }

    fun getCurrentDateDash(diff: Int = 0): String {
        return try {
            val calendar = Calendar.getInstance()
            calendar.add(Calendar.DAY_OF_YEAR, -diff)
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH )

            return "$year-${month.plus(1)}-${dayOfMonth.plus(1)}"
        } catch (e: Exception) {
            "-"
        }
    }
    // signal
    fun getCurrentDateSlash(diff: Int = 0): String {
        return try {
            val calendar = Calendar.getInstance()
            calendar.add(Calendar.DAY_OF_YEAR, -diff)
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
            return "$year/${month.plus(1)}/$dayOfMonth"
        } catch (e: Exception) {
            "-"
        }
    }
    // invoice
    fun getCurrentDateSlashFirstDay(diff: Int = 0): String {
        return try {
            val calendar = Calendar.getInstance()
            calendar.add(Calendar.DAY_OF_YEAR, -diff)
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
            return "$dayOfMonth/${month.plus(1)}/$year"
        } catch (e: Exception) {
            "-"
        }
    }
    fun formatGetDayHistory(date: String): String {
        return try {
            val date = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(date)
            val calendar = Calendar.getInstance().apply { time = date!! }
            String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH))
        } catch (e: Exception) {
            "-"
        }
    }

    fun formatGetMonthNameHistory(date: String): String {
        return try {
            val date = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale("tr")).parse(date)
            DateFormat.format("MMMM", date).toString()
        } catch (e: Exception) {
            "-"
        }
    }

    fun formatGetYearHistory(date: String): String {
        return try {
            val date = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(date)
            val calendar = Calendar.getInstance().apply { time = date!! }
            calendar.get(Calendar.YEAR).toString()
        } catch (e: Exception) {
            "-"
        }
    }

    fun getCurrentDateSignal(): String {
        return try {
            val timeInMillis = System.currentTimeMillis()
            val cal1 = Calendar.getInstance()
            cal1.timeInMillis = timeInMillis
            val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH)
            sdf.format(cal1.time)
        } catch (e: Exception) {
            "-"
        }
    }

    fun formatServerTime(date: String): String {
        return try {
            val date1 =
                SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS", Locale.getDefault()).parse(date)
            val calendar = Calendar.getInstance().apply { time = date1!! }
            val year = calendar.get(Calendar.YEAR)
            val month = String.format("%02d", calendar.get(Calendar.MONTH) + 1)
            val day = String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH))
            val hour = String.format("%02d", calendar.get(Calendar.HOUR))
            val min = String.format("%02d", calendar.get(Calendar.MINUTE))
            "$day.$month.$year $hour:$min"
        } catch (e: Exception) {
            "-"
        }
    }

    fun formatDateMonthName(date: String): String {
        return try {
            val tmp = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault()).parse(date)
            SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
                .format(tmp)
        } catch (e: Exception) {
            "-"
        }
    }

    fun getDifferenceBetweenNow(dateString: String): Long {
        return try {
            val formatter =
                SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
            formatter.timeZone = TimeZone.getTimeZone("UTC")
            val endDateTime = formatter.parse(dateString)

            val nowDateTime: Date = Calendar.getInstance().time

            endDateTime?.time?.minus(nowDateTime.time) ?: 0L // Difference as Long
        } catch (e: Exception) {
            0L
        }
    }
}