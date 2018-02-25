package net.edventurer.lofmessanger.net

import io.reactivex.Observable
import net.edventurer.lofmessanger.net.response.MessagesResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by akvus on 2/17/18.
 */
interface ApiInterface {
    // todo should be by POST
    @GET("?action=add")
    fun sendMessage(
            @Query("token") token: String,
            @Query("nickname") nickname: String,
            @Query("message") message: String) : Observable<MessagesResponse>

    @GET("?action=get")
    fun getMessages(
            @Query("token") token: String,
            @Query("nickname") nickname: String) : Observable<MessagesResponse>
}