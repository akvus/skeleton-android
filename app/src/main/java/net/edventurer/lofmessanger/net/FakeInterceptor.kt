package net.edventurer.lofmessanger.net

import okhttp3.*

/**
 * Created by akvus on 2/17/18.
 */
class FakeInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val responseString =
                "{\"error\": 0, \"messages\":[{\"message\":\"Some message\", \"nickname\":\"Alice\", \"timestamp\": 1519592549000}, " +
                        "{\"message\":\"Some message2\", \"nickname\":\"Alice\", \"timestamp\": 1519592549000}]}"

        return Response.Builder()
                .code(200)
                .message(responseString)
                .request(chain.request())
                .protocol(Protocol.HTTP_1_0)
                .body(ResponseBody.create(MediaType.parse("application/json"), responseString.toByteArray()))
                .addHeader("content-type", "application/json")
                .build();
    }

}