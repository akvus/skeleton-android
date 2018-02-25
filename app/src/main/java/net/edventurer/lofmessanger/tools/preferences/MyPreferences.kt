package net.edventurer.lofmessanger.tools.preferences

import android.content.SharedPreferences

/**
 * Created by akvus on 2/20/18.
 */
class MyPreferences(sharedPreferences: SharedPreferences) : Preferences(sharedPreferences) {
    fun getNickname(): String {
        return getString(nicknameKey, defaultNickName)
    }

    fun getApiUrl(): String {
        return if (getString(apiUrlKey).isEmpty()) defaultApiUrl else getString(apiUrlKey)
    }

    companion object {
        const val nicknameKey = "nickPreference"
        const val apiUrlKey = "urlPreference"

        const val defaultNickName = "User"
        const val defaultApiUrl = "http://api.example.com/v1/"
    }
}