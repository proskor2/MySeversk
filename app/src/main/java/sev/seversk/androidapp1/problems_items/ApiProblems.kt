package sev.seversk.androidapp1.problems_items

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import sev.seversk.androidapp1.events_items.Afisha
import sev.seversk.androidapp1.events_items.ApiAfisha
import java.util.*

interface ApiProblems {

    @GET("treatments")
    @Headers("Accept: application/json", "Authorization: Bearer eAshM2HGUf3tAgYormBzY6cpe4lADxwi")

    fun getProblems() : retrofit2.Call<List<Problem>>

    @POST("treatments")
    @Headers("Accept: multipart/form-data", "Authorization: Bearer eAshM2HGUf3tAgYormBzY6cpe4lADxwi")

    fun addProblem(@Body problem: Problem) : retrofit2.Call<Problem>

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