package sev.seversk.androidapp1.authorization

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RestApiService {
    fun addUser(tokenData: tokenInfo, onResult: (tokenInfo?) -> Unit){
        val retrofit = ServiceBuilder.buildService(ApiPostToken::class.java)
        retrofit.addToken(tokenData).enqueue(
            object : Callback<tokenInfo> {
                override fun onFailure(call: Call<tokenInfo>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<tokenInfo>, response: Response<tokenInfo>) {
                    val addedUser = response.body()
                    onResult(addedUser)
                }
            }
        )
    }
}