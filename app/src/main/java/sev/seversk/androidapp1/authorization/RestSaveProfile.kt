package sev.seversk.androidapp1.authorization

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import com.liftric.kvault.KVault
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestSaveProfile {

    companion object {
        private lateinit var context: Context
        fun setContext(con: Context) {
            context=con
        }
    }

    val kVault = KVault(context = context)
    val token2 = kVault.string("TOKEN")
    fun saveUser(userData: saveProfile, onResult: (saveProfile?) -> Unit){
        val retrofit = ServiceBuilder.buildService(ApiSaveProfile::class.java)
        retrofit.saveProfile(userData, "Bearer " + token2).enqueue(
            object : Callback<saveProfile> {
                override fun onFailure(call: Call<saveProfile>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse(call: Call<saveProfile>, response: Response<saveProfile>) {
                    val addedUser = response.body()
                    onResult(addedUser)
                }
            }
        )
    }
}