package sev.seversk.androidapp1.authorization

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.provider.Telephony
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.liftric.kvault.KVault
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiSaveProfile {

    @POST("profile")
    @Headers("Content-Type: application/json")
    fun saveProfile (@Body userData: saveProfile, @Header("Authorization") token: String = "Bearer" + takeToken().gettok ): Call<saveProfile>

}

