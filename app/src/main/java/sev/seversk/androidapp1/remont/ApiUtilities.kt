package sev.seversk.androidapp1.remont

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface ApiUtilities {
    @GET("utilities")
    @Headers("Accept: application/json")
    fun getUtil(@Header("Authorization") token:String) : retrofit2.Call<List<utilities>>

    companion object {
        var BASE_URL = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/geocad/"
        fun create() : ApiUtilities{
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiUtilities::class.java)
        }
    }
}