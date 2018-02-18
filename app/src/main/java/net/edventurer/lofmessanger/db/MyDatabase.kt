package net.edventurer.lofmessanger.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context

import net.edventurer.lofmessanger.db.dao.MessageDao
import net.edventurer.lofmessanger.db.data.Message

/**
 * Created by akvus on 2/18/18.
 */
@Database(entities = [Message::class], version = MyDatabase.VERSION, exportSchema = false)
@TypeConverters(Converters::class)
abstract class MyDatabase : RoomDatabase() {
    abstract fun messageDao(): MessageDao

    companion object {
        private const val NAME = "lof-db"
        const val VERSION = 1

        fun create(context: Context): MyDatabase {
            return Room.databaseBuilder(context, MyDatabase::class.java, MyDatabase.NAME).build()
        }
    }
}