package sev.seversk.androidapp1.alerts_items

import com.google.firebase.auth.FirebaseAuth
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import sev.seversk.androidapp1.news_items.ApiInterface
import sev.seversk.androidapp1.news_items.News

interface ApiAlert {


    @GET("alerts")

    @Headers("Accept: application/json")


    fun getAlert(@Header("Authorization") token: String) : retrofit2.Call<List<Alert>>

    companion object {

        var BASE_URL = "https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/"

        fun create() : ApiAlert {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiAlert::class.java)
        }
    }
}

val token1 = FirebaseAuth.getInstance().currentUser?.uid