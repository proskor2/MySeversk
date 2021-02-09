package sev.seversk.androidapp1.comment

import retrofit2.Call
import retrofit2.http.*
import sev.seversk.androidapp1.authorization.saveProfile

interface ApiSendCommentNews {

    @FormUrlEncoded
    @POST("comments")
    @Headers("Content-Type: multipart/form-data")
    fun sendComment (@Field("comment_text") coomment_text: String, @Header("Authorization") token: String, @Query("owner_name") owner: String, @Query("owner_id") ownid: String): Call<sendComment>
}