package sev.seversk.androidapp1.authorization

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestSaveProfile {
    fun addUser(userData: saveProfile, onResult: (saveProfile?) -> Unit){
        val retrofit = ServiceBuilder.buildService(ApiSaveProfile::class.java)
        retrofit.saveProfile(userData).enqueue(
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