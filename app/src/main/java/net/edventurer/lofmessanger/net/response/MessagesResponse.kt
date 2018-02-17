package net.edventurer.lofmessanger.net.response

import com.google.gson.annotations.SerializedName

/**
 * Created by akvus on 2/17/18.
 */
class MessagesResponse : NetworkResponse() {
    @SerializedName("messages")
    val messages: Array<String> = arrayOf()
}