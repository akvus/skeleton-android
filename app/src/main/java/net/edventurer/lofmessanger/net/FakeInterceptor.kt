package net.edventurer.lofmessanger.net

import okhttp3.*

/**
 * Created by akvus on 2/17/18.
 */
class FakeInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val uri = chain.request().url().uri();

        val responseString = "{\"messages\":[{\"message\":\"Some message\", \"nickname\":\"Ann\"}, {\"message\":\"Some message\", \"nickname\":\"Ann\"}]}"
        return  Response.Builder()
                .code(200)
                .message(responseString)
                .request(chain.request())
                .protocol(Protocol.HTTP_1_0)
                .body(ResponseBody.create(MediaType.parse("application/json"), responseString.toByteArray()))
                .addHeader("content-type", "application/json")
                .build();
    }

}