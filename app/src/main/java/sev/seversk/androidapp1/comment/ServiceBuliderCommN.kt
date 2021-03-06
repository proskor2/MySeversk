package sev.seversk.androidapp1.comment

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuliderCommN {

    private val client = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/") // change this IP for testing by your actual machine IP
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }

}