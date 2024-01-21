package com.example.baseapplication.core.network.interceptors.prettyJson

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.util.Date

object GsonProvider {
    private val gson: Gson = GsonBuilder()
        .registerTypeAdapter(Date::class.java, DateAdapter())
        .create()

    fun get(): Gson {
        return gson
    }

    private val prettyGson: Gson = GsonBuilder()
        .setPrettyPrinting()
        .create()

    fun getPrettyGson(): Gson {
        return prettyGson
    }
}