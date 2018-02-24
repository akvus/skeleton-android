package net.edventurer.lofmessanger.net

import io.reactivex.Observable
import net.edventurer.lofmessanger.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by akvus on 2/17/18.
 */
object ApiClient {
    private val okHttpClient: OkHttpClient by lazy {
        val httpClientBuilder = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            httpClientBuilder.addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }

        httpClientBuilder.build()
    }

    val service: ApiInterface by lazy {
        Retrofit.Builder()
                .baseUrl("http://api.example.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create<ApiInterface>(ApiInterface::class.java)
    }

    fun get(url: String): Observable<ResponseBody> {
        return Observable.fromCallable<ResponseBody> {
            val request = Request.Builder().url(url).build()
            val response = okHttpClient.newCall(request).execute()
            response.body()
        }
    }
}