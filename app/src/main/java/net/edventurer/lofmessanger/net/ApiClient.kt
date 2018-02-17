package net.edventurer.lofmessanger.net

import net.edventurer.lofmessanger.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by akvus on 2/17/18.
 */
object ApiClient {
    val service: ApiInterface by lazy {
        val httpClientBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            httpClientBuilder.addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }
        Retrofit.Builder()
                .baseUrl("http://api.example.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create<ApiInterface>(ApiInterface::class.java)
    }
}