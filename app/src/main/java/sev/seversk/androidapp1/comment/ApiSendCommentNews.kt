package sev.seversk.androidapp1.comment

import retrofit2.Call
import retrofit2.http.*
import sev.seversk.androidapp1.authorization.saveProfile

interface ApiSendCommentNews {

    @POST("comments")
    @Headers("Content-Type: application/json")
    fun sendComment (@Body sendComment: sendComment, @Header("Authorization") token: String, @Query("owner_name") owner: String, @Query("owner_id") ownid: String): Call<sendComment>

}