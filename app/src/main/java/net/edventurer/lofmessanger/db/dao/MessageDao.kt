package net.edventurer.lofmessanger.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import io.reactivex.Flowable
import net.edventurer.lofmessanger.db.data.LofMessage

/**
 * Created by akvus on 2/18/18.
 */
@Dao
interface MessageDao {
    @Query("select * from message")
    fun getAllMessages() : Flowable<List<LofMessage>>

    @Insert(onConflict = REPLACE)
    fun insertMessage(lofMessage: LofMessage)

    @Delete
    fun deleteMessage(lofMessage: LofMessage)
}