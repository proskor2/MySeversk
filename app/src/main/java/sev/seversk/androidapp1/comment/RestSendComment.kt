package sev.seversk.androidapp1.comment

import android.content.Context
import com.liftric.kvault.KVault
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sev.seversk.androidapp1.authorization.ApiSaveProfile
import sev.seversk.androidapp1.authorization.ServiceBuilder
import sev.seversk.androidapp1.authorization.saveProfile

class RestSendComment2 {

//    companion object {
//        private lateinit var context: Context
//        fun setContext(con: Context) {
//            context=con
//        }
//    }
//
//    val kVault = KVault(context = context)
//    val token2 = kVault.string("TOKEN")
//
//    fun sendComment (comData: sendComment, onResult: (sendComment?) -> Unit){
//        val retrofit = ServiceBuilder.buildService(ApiSendCommentNews::class.java)
//        retrofit.sendComment(comData, "Bearer " + token2, ).enqueue(
//            object : Callback<sendComment> {
//                override fun onFailure(call: Call<sendComment>, t: Throwable) {
//                    onResult(null)
//                }
//                override fun onResponse(call: Call<sendComment>, response: Response<sendComment>) {
//                    val sendComment = response.body()
//                    onResult(sendComment)
//                }
//            }
//        )
//    }
}