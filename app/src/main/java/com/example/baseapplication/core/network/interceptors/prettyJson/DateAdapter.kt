package com.example.baseapplication.core.network.interceptors.prettyJson

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import java.lang.reflect.Type
import java.util.Date

class DateAdapter : JsonSerializer<Date>, JsonDeserializer<Date> {
    override fun serialize(
        src: Date?,
        typeOfSrc: Type?,
        context: JsonSerializationContext?
    ): JsonElement {
        return if (src == null) {
            JsonPrimitive(0)
        } else {
            JsonPrimitive(src.time)
        }
    }

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Date? {
        if (json != null && json.isJsonPrimitive && (json as JsonPrimitive).isNumber) {
            return Date(json.asLong)
        }

        return null
    }
}