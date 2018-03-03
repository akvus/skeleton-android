package net.edventurer.lofmessanger.ext

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by akvus on 3/3/18.
 */

fun Date.formatted(format: String): String =
        SimpleDateFormat(format, Locale.ENGLISH).format(this)