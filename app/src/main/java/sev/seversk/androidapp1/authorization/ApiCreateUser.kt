package sev.seversk.androidapp1.authorization

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiCreateUser {
    @POST("create")
    @Headers("Content-Type: application/json")
    fun addUser(@Body userData: createUserInfo): Call<createUserInfo>
}