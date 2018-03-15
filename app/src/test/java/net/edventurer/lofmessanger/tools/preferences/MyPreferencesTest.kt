package net.edventurer.lofmessanger.tools.preferences

import android.content.SharedPreferences
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by maciejz on 15/03/18.
 */
@RunWith(MockitoJUnitRunner::class)
class MyPreferencesTest {
    @Mock
    lateinit var sharedPreferences: SharedPreferences

    var myPreferences: MyPreferences? = null

    @Before
    fun init() {
        myPreferences = MyPreferences(sharedPreferences)
        Mockito.`when`(sharedPreferences.getString(anyString(), anyString()))
                .thenReturn("")
    }

    @Test
    fun getNickName() {
        myPreferences?.getNickname()
        Mockito.verify(sharedPreferences, Mockito.times(1))
                .getString(MyPreferences.nicknameKey, MyPreferences.defaultNickName)
    }

    @Test
    fun getApiUrl() {
        myPreferences?.getApiUrl()
        Mockito.verify(sharedPreferences, Mockito.times(1))
                .getString(MyPreferences.apiUrlKey, "")
    }

    @Test
    fun getToken() {
        myPreferences?.getToken()
        Mockito.verify(sharedPreferences, Mockito.times(1))
                .getString(MyPreferences.tokenKey, "")
    }
}