package sev.seversk.androidapp1.news_items

import android.content.Context
import android.content.res.Resources
import android.provider.Settings.Global.getString
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import sev.seversk.androidapp1.R

interface ApiInterface {

    @GET("news")
    @Headers("Accept: application/json")


    fun getNews(@Header("Authorization") token: String) : retrofit2.Call<List<News>>

    companion object {

        var BASE_URL = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/"

        fun create() : ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }

//    @GET("news")
//    @Headers("Accept: application/json", "Authorization: Bearer eAshM2HGUf3tAgYormBzY6cpe4lADxwi")
//
//
//    fun getNews() : retrofit2.Call<List<News>>
//
//    companion object {
//
//        var BASE_URL = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/"
//
//        fun create() : ApiInterface {
//
//            val retrofit = Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl(BASE_URL)
//                .build()
//            return retrofit.create(ApiInterface::class.java)
//        }
//    }
}






