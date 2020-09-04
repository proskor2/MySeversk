package sev.seversk.androidapp1.problems_items

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import sev.seversk.androidapp1.events_items.Afisha
import sev.seversk.androidapp1.events_items.ApiAfisha

interface ApiProblems {

    @GET("treatments")

    @Headers("Accept: application/json", "Authorization: Bearer eAshM2HGUf3tAgYormBzY6cpe4lADxwi")


    fun getProblems() : retrofit2.Call<List<Problem>>

    companion object {

        var BASE_URL = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/"

        fun create() : ApiProblems {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiProblems::class.java)
        }
    }
}