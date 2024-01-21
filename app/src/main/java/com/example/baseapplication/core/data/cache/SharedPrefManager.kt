package com.example.baseapplication.core.data.cache

import android.content.SharedPreferences
import com.example.baseapplication.common.utils.extension.core.get
import com.example.baseapplication.common.utils.extension.core.remove
import com.example.baseapplication.common.utils.extension.core.set
import javax.inject.Inject

class SharedPrefManager @Inject constructor(private val preferences: SharedPreferences) {

    var isTestValue: Boolean?
        get() = preferences.get(SharedCacheKey.Test.cacheKeyName)
        set(value) {
            preferences.set(SharedCacheKey.Test.cacheKeyName, value)
        }

    fun removeCacheList(vararg sharedCacheKey: SharedCacheKey) {
        sharedCacheKey.forEach {
            preferences.remove(it.cacheKeyName)
        }

    }

    fun clearCache() {
        SharedCacheKey.values().forEach {
            preferences.remove(it.cacheKeyName)
        }
    }
}


enum class SharedCacheKey(val cacheKeyName: String) {
    Test("")
}
