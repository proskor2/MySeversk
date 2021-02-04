package sev.seversk.androidapp1.opros_items

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import sev.seversk.androidapp1.events_items.Afisha
import sev.seversk.androidapp1.events_items.ApiAfisha

interface ApiOpros {

    @GET("questionnaires")

    @Headers("Accept: application/json")


    fun getOpros(@Header("Authorization") token: String) : retrofit2.Call<List<Opros>>

    companion object {

        var BASE_URL = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/"

        fun create() : ApiOpros {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiOpros::class.java)
        }
    }
}