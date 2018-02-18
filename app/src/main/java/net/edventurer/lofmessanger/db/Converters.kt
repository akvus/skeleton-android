package net.edventurer.lofmessanger.db

import android.arch.persistence.room.TypeConverter
import java.util.*


/**
 * Created by akvus on 2/18/18.
 *
 * todo use https://medium.com/@chrisbanes/room-time-2b4cf9672b98 back ported OffsetDateTime
 */
object Converters {
    @TypeConverter
    @JvmStatic
    fun fromTimestamp(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    @TypeConverter
    @JvmStatic
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}