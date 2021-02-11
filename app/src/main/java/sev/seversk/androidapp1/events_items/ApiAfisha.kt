package sev.seversk.androidapp1.events_items

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers


interface ApiAfisha {


    @GET("afisha")
    @Headers("Accept: application/json")

    fun getAfisha(@Header("Authorization") token: String) : retrofit2.Call<List<Afisha>>

    companion object {

        var BASE_URL = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/"

        fun create() : ApiAfisha {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiAfisha::class.java)
        }
    }
}