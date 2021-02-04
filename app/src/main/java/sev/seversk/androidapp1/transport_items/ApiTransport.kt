package sev.seversk.androidapp1.transport_items

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers


interface ApiTransport {


    @GET("traffic")

    @Headers("Accept: application/json")


    fun getTransport(@Header("Authorization") token: String) : retrofit2.Call<List<Transport>>

    companion object {

        var BASE_URL = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/"

        fun create() : ApiTransport {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiTransport::class.java)
        }
    }
}