package net.edventurer.lofmessanger.tools

import net.edventurer.lofmessanger.ext.hexToByteArray
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Created by akvus on 3/3/18.
 */
@RunWith(JUnit4::class)
class AesCipherTest {

    private val text = "To be encrypted"
    private val key = "ab1234abab1234abab1234abab1234ab".hexToByteArray()
    private val iv = "12345678123456781234567812345678".hexToByteArray()

    @Test
    fun hexToBytes() {
        val bytes = "a789".hexToByteArray()
        assertThat(bytes, equalTo(byteArrayOf(-89, -119)))
    }

    @Test
    fun encryptDecrypt() {
        val encrypted = AesCipher.encrypt(iv, key, text.toByteArray())
        val decrypted = String(AesCipher.decrypt(iv, key, encrypted), Charsets.UTF_8)
        assertThat(decrypted, equalTo(text))
    }

    fun encrypt() {
        // todo
    }

    fun decrypt() {
        // todo
    }
}