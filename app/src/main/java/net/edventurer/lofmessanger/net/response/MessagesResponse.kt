package net.edventurer.lofmessanger.net.response

import com.google.gson.annotations.SerializedName
import net.edventurer.lofmessanger.db.data.LofMessage

/**
 * Created by akvus on 2/17/18.
 */
class MessagesResponse : NetworkResponse() {
    @SerializedName("messagesToAdd")
    val lofMessages: List<LofMessage> = listOf()
}