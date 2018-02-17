package net.edventurer.lofmessanger.net.response

import com.google.gson.annotations.SerializedName

/**
 * Created by akvus on 2/17/18.
 */
open class NetworkResponse {
    @SerializedName("errors")
    val errors: Array<String> = arrayOf()
    @SerializedName("success")
    var success: Int = 0
}