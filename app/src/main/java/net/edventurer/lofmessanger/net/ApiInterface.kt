package net.edventurer.lofmessanger.net

import io.reactivex.Observable
import net.edventurer.lofmessanger.net.response.MessagesResponse
import net.edventurer.lofmessanger.net.response.NetworkResponse
import retrofit2.http.*

/**
 * Created by akvus on 2/17/18.
 */
interface ApiInterface {
    @FormUrlEncoded
    @POST("message")
    fun sendMessage(@Field("nickname") nickname: String, @Field("message") message: String)
            : Observable<NetworkResponse>

    @GET("message/{nickname}")
    fun retrieveMessages(@Path("nickname") nickname: String) : Observable<MessagesResponse>
}