package net.edventurer.lofmessanger.net.response

import com.google.gson.annotations.SerializedName
import net.edventurer.lofmessanger.db.data.Message

/**
 * Created by akvus on 2/17/18.
 */
class MessagesResponse : NetworkResponse() {
    @SerializedName("messages")
    val messages: List<Message> = listOf()
}