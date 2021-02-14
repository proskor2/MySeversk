package sev.seversk.androidapp1.events_items

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path
import sev.seversk.androidapp1.comment.ApiComment
import sev.seversk.androidapp1.comment.comments

interface ApiEventComment {

    @GET("{id}")
    @Headers("Accept: application/json")

    fun getComment(@Path("id") id: Int, @Header("Authorization") token: String) : Call<comments>

    companion object {

        var BASE_URL = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/comments/afisha/"

        fun create() : ApiComment {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiComment::class.java)
        }
    }
}