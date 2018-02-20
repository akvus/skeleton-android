package net.edventurer.lofmessanger.tools.preferences

import android.content.SharedPreferences

/**
 * Created by akvus on 2/20/18.
 */
class MyPreferences(sharedPreferences: SharedPreferences): Preferences(sharedPreferences) {
    fun getNick(): String {
        return getString(nicknameKey) ?: ""
    }

    fun getUrl(): String {
        return getString(urlKey) ?: ""
    }

    companion object {
        const val nicknameKey = "nick"
        const val urlKey = "url"
    }
}