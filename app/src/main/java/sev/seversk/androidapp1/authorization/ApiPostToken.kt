package sev.seversk.androidapp1.authorization

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiPostToken {

    @POST("/auth/checktoken")
    fun addToken(@Body tokenData: tokenInfo): Call<tokenInfo>

}