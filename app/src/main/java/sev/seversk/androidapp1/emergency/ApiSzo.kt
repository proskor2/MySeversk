package sev.seversk.androidapp1.emergency

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface ApiSzo {

    @GET("szo")
    @Headers("Accept: application/json")
    fun getSzo(@Header("Authorization") token:String) : retrofit2.Call<List<Szo>>

    companion object {

        var BASE_URL = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/geocad/"

        fun create() : ApiSzo {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiSzo::class.java)
        }
    }
}