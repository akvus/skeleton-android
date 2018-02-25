package net.edventurer.lofmessanger.net.response

import com.google.gson.annotations.SerializedName
import net.edventurer.lofmessanger.db.data.LofMessage

/**
 * Created by akvus on 2/17/18.
 */
class MessagesResponse : NetworkResponse() {
    @SerializedName("error")
    val error: Int = 0

    @SerializedName("messages")
    val messages: List<LofMessage> = listOf()
}