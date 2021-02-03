package sev.seversk.androidapp1.comment

import com.google.gson.annotations.SerializedName

data class comment (
    @SerializedName("title") val title: String?,
    @SerializedName("comments") val comments: String?,
    @SerializedName("comments_id") val comments_id: String?,
    @SerializedName("user") val user: String?,
    @SerializedName("comment_text") val comment_text: String?,
    @SerializedName("create_time") val create_time: String?,
    @SerializedName("status") val status: String?
        )