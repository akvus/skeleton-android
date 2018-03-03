package net.edventurer.lofmessanger.ext

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by akvus on 3/3/18.
 */

fun Date.formatted(format: String): String =
        SimpleDateFormat(format, Locale.ENGLISH).format(this)

fun String.hexToByteArray(): ByteArray {
    val data = ByteArray(length / 2)
    var i = 0
    while (i < length) {
        data[i / 2] = ((Character.digit(this[i], 16) shl 4) + Character.digit(this[i + 1], 16)).toByte()
        i += 2
    }
    return data
}