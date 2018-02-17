package net.edventurer.lofmessanger.db

import com.google.gson.annotations.SerializedName

/**
 * Created by akvus on 2/17/18.
 */
data class Message(
        @SerializedName("id") val id: Long,
        @SerializedName("message") val message: String,
        @SerializedName("nickname") val nickname: String)