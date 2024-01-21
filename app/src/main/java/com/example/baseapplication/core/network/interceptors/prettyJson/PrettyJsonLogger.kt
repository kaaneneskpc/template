package com.example.baseapplication.core.network.interceptors.prettyJson

import com.google.gson.JsonParser
import okhttp3.internal.platform.Platform
import okhttp3.logging.HttpLoggingInterceptor

internal class PrettyJsonLogger : HttpLoggingInterceptor.Logger {
    override fun log(message: String) {
        val trimmedMessage = message.trim()
        if ((trimmedMessage.startsWith("{") && trimmedMessage.endsWith("}")) || (trimmedMessage.startsWith(
                "["
            ) && trimmedMessage.endsWith("]"))
        ) {
            try {
                Platform.get()
                    .log(GsonProvider.getPrettyGson().toJson(JsonParser.parseString(message)))
            } catch (e: Exception) {
                Platform.get().log(message)
            }
        } else {
            Platform.get().log(message)
        }
    }
}