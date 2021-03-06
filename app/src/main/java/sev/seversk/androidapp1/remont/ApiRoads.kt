package sev.seversk.androidapp1.remont

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import sev.seversk.androidapp1.emergency.ApiEmerg
import sev.seversk.androidapp1.emergency.Emergency

interface ApiRoads {

    @GET("roads")
    @Headers("Accept: application/json")
    fun getRoads(@Header("Authorization") token:String) : retrofit2.Call<List<roads>>

    companion object {
        var BASE_URL = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/geocad/"
        fun create() : ApiRoads{
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiRoads::class.java)
        }
    }
}