package net.edventurer.lofmessanger.tools.preferences

import android.content.SharedPreferences
import androidx.content.edit

/**
 * Created by akvus on 2/20/18.
 */
abstract class Preferences(private val sharedPreferences: SharedPreferences) {
    fun getString(key: String, default: String = ""): String {
        return sharedPreferences.getString(key, default)
    }

    fun putString(key: String, value: String) {
        sharedPreferences.edit {
            putString(key, value)
        }
    }

    fun getBoolean(key: String, default: Boolean = false): Boolean {
        return sharedPreferences.getBoolean(key, default)
    }

    fun putBoolean(key: String, value: Boolean) {
        sharedPreferences.edit {
            putBoolean(key, value)
        }
    }
}