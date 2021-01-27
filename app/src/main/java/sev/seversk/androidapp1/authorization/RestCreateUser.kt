package sev.seversk.androidapp1.authorization

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestCreateUser {
    fun addUser(userData: createUserInfo, onResult: (createUserInfo?) -> Unit){
        val retrofit = ServiceBuilder.buildService(ApiCreateUser::class.java)
        retrofit.addUser(userData).enqueue(
            object : Callback<createUserInfo> {
                override fun onFailure(call: Call<createUserInfo>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse(call: Call<createUserInfo>, response: Response<createUserInfo>) {
                    val addedUser = response.body()
                    onResult(addedUser)
                }
            }
        )
    }
}