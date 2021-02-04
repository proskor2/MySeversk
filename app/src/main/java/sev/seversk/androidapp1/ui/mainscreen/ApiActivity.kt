package sev.seversk.androidapp1.ui.mainscreen

import android.annotation.SuppressLint
import kotlinx.android.synthetic.main.fragment_appeals.*
import okhttp3.*
import org.json.JSONArray
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import java.io.IOException


interface ApiActivity {


    @GET("activity")

    @Headers("Accept: application/json")


    fun getActiv(@Header("Authorization") token: String) : retrofit2.Call<List<Activ>>

    companion object {


        var BASE_URL = ("https://xn--80aqu.xn----7sbhlbh0a1awgee.xn--p1ai/v1/")

        fun create() : ApiActivity {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiActivity::class.java)
        }
    }


}


