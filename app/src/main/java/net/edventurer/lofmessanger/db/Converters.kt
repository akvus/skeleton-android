package net.edventurer.lofmessanger.db

import android.arch.persistence.room.TypeConverter
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

/**
 * Created by akvus on 2/18/18.
 */
object MyTypeConverter {
    private val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME

    @TypeConverter
    @JvmStatic
    fun toOffsetDateTime(value: String?): OffsetDateTime? {
        return value?.let {
            return formatter.parse(value, OffsetDateTime::from)
        }
    }

    @TypeConverter
    @JvmStatic
    fun fromOffsetDateTime(date: OffsetDateTime?): String? {
        return date?.let {
            it.format(formatter)
        }
    }
}