package sev.seversk.androidapp1.authorization

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import com.liftric.kvault.KVault
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestSaveProfile {


    val token= "eyJhbGciOiJSUzI1NiIsImtpZCI6IjljZTVlNmY1MzBiNDkwMTFiYjg0YzhmYWExZWM1NGM1MTc1N2I2NTgiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL3NlY3VyZXRva2VuLmdvb2dsZS5jb20vbXlzZXZlcnNrIiwiYXVkIjoibXlzZXZlcnNrIiwiYXV0aF90aW1lIjoxNjEyMjMyOTk0LCJ1c2VyX2lkIjoiYWlIQlVhZ3puYVc2SFNUbk5WTjVlS1o5ZXZxMSIsInN1YiI6ImFpSEJVYWd6bmFXNkhTVG5OVk41ZUtaOWV2cTEiLCJpYXQiOjE2MTIyMzI5OTUsImV4cCI6MTYxMjIzNjU5NSwicGhvbmVfbnVtYmVyIjoiKzcxMDAyMDAzMzMzIiwiZmlyZWJhc2UiOnsiaWRlbnRpdGllcyI6eyJwaG9uZSI6WyIrNzEwMDIwMDMzMzMiXX0sInNpZ25faW5fcHJvdmlkZXIiOiJwaG9uZSJ9fQ.iy8j_m2ToWqPxuu-QOJG4IPvQAPKbROS9Te3JNPuHgbKngDQmeEieI0Nzz1n8PZ-HAvcQnMj-r-DsUwcREsV-R-VeMUPq2BJLJDDOtVWSC3MO-pbBAQ1EesZ7lgmcCsKoO50VTyJ7XlmVSGvlDmuOMIikK0AtW9PvW-xNHtJqgFsilQNQ2vPZHLExax6Hc9mbRu1z0H6g_ZAa83sTSxRcE8AtBxliJ72RHyHkxT19Fg0-bbzb3TRzggzDxXNzvE3Qgky8GSUj3CyNmEvhjsKCtf7tChpmamRxrufDumlprcmi2xUQjg75dqSlq1IWi3yoR0UEECjpU9T4stDpVgwYw"
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