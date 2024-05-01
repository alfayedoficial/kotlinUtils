package com.alfayedoficial.kotlinutils

import android.content.SharedPreferences
import com.google.gson.Gson

class KUEncryptedPreferences (private val mSharedPreferences: SharedPreferences, private val mSharedPreferencesEditor: SharedPreferences.Editor) {

    init {
        mSharedPreferencesEditor.apply()
    }

    /**
     * @param key
     * @param value
     * save in SharedPreferences by key
     */
    fun setValue(key: String, value: Any?) {
        when (value) {
            is Int? -> {
                mSharedPreferencesEditor.putInt(key, value!!)
                mSharedPreferencesEditor.apply()
            }
            is String? -> {
                mSharedPreferencesEditor.putString(key, value!!)
                mSharedPreferencesEditor.apply()
            }
            is Double? -> {
                mSharedPreferencesEditor.putString(key, value.toString())
                mSharedPreferencesEditor.apply()
            }
            is Long? -> {
                mSharedPreferencesEditor.putLong(key, value!!)
                mSharedPreferencesEditor.apply()
            }
            is Boolean? -> {
                mSharedPreferencesEditor.putBoolean(key, value!!)
                mSharedPreferencesEditor.apply()
            }
            is  Any ->{
                mSharedPreferencesEditor.putString(key,  Gson().toJson(value))
                mSharedPreferencesEditor.apply()
            }
        }
    }

    /**
     * @param key
     * @param defaultValue
     * get from SharedPreferences by key
     */
    fun getStringValue(key: String, defaultValue: String = ""): String {
        return mSharedPreferences.getString(key, defaultValue)!!
    }

    /**
     * @param key
     * @param defaultValue
     * get from SharedPreferences by key
     */
    fun getIntValue(key: String, defaultValue: Int): Int {
        return mSharedPreferences.getInt(key, defaultValue)
    }

    /**
     * @param key
     * @param defaultValue
     * get from SharedPreferences by key
     */
    fun getLongValue(key: String, defaultValue: Long): Long {
        return mSharedPreferences.getLong(key, defaultValue)
    }

    /**
     * @param key
     * @param defaultValue
     * get from SharedPreferences by key
     */
    fun getBooleanValue(key: String, defaultValue: Boolean = false): Boolean {
        return mSharedPreferences.getBoolean(key, defaultValue)
    }

    /**
     * @param key
     * @param defaultValue
     * get from SharedPreferences by key
     */
    fun getFloatValue(key: String, defaultValue: Float): Float {
        return mSharedPreferences.getFloat(key, defaultValue)
    }

    /**
     * @param key
     * @param defaultValue
     * get from SharedPreferences by key
     */
    fun getDoubleValue(key: String, defaultValue: Double): Double {
        val doubleAsString = mSharedPreferences.getString(key, defaultValue.toString())
        return doubleAsString?.toDouble() ?: defaultValue
    }

    /**
     * @param key
     * @param defaultValue
     * get from SharedPreferences by key
     */
    fun <T : Any> getObject(key: String, defaultValue: T): T {
        val json = mSharedPreferences.getString(key, "")
        return if (json != null) {
            Gson().fromJson(json, defaultValue::class.java)
        } else {
            defaultValue
        }
    }



    /**
     * @param key
     * remove value from SharedPreferences by key
     */
    fun removeKey(key: String) {
        mSharedPreferencesEditor.remove(key)
        mSharedPreferencesEditor.apply()
    }

    /**
     * clear SharedPreferences
     */
    fun clear() {
        mSharedPreferencesEditor.clear().apply()
    }
}
