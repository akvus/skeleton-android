package net.edventurer.lofmessanger.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import net.edventurer.lofmessanger.db.data.Message

/**
 * Created by akvus on 2/18/18.
 */
@Dao
interface MessageDao {
    @Query("select * from message")
    fun getAllMessages() : List<Message>

    @Insert(onConflict = REPLACE)
    fun insertMessage(message: Message)

    @Delete
    fun deleteMessage(message: Message)
}