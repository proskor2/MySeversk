package sev.seversk.androidapp1.authorization

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

object ServiceBuilder {
        private val client = OkHttpClient.Builder().build()

        private val retrofit = Retrofit.Builder()
            .baseUrl("https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/user/") // change this IP for testing by your actual machine IP
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()


        fun <T> buildService(service: Class<T>): T {
            return retrofit.create(service)
        }

    }
