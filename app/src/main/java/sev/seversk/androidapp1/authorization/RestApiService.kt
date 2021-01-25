package sev.seversk.androidapp1.authorization

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sev.seversk.androidapp1.authorization.ServiceBuilder.ServiceBuilder.buildService

class RestApiService {
    fun addToken(tokenData: tokenInfo, onResult: (tokenInfo?) -> Unit){
//
////        val retrofit = ServiceBuilder.ServiceBuilder.buildService()
//
//        retrofit.addToken(tokenData).enqueue(
//            object : Callback<tokenInfo> {
//                override fun onFailure(call: Call<tokenInfo>, t: Throwable) {
//                    onResult(null)
//                }
//                override fun onResponse( call: Call<tokenInfo>, response: Response<tokenInfo>) {
//                    val addedToken = response.body()
//                    onResult(addedToken)
//                }
//            }
//        )
    }
}