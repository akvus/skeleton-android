package net.edventurer.lofmessanger.db.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by akvus on 2/17/18.
 */
@Entity(tableName = "message")
data class Message(
        @ColumnInfo(name = "message")
        @SerializedName("message") val message: String,
        @ColumnInfo(name = "date")
        @SerializedName("date") val date: Date,
        @ColumnInfo(name = "nickname")
        @SerializedName("nickname") val nickname: String) {
    @ColumnInfo(name = "id")
    @SerializedName("id")
    @PrimaryKey(autoGenerate = true) var id: Long = 0
}