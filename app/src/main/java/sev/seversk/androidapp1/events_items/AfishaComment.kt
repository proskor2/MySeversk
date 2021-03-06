package sev.seversk.androidapp1.events_items

import com.google.gson.annotations.SerializedName

data class AfishaComment(
    @SerializedName("title") val title: String?,
    @SerializedName("comments") val comments: String?,
    @SerializedName("comment_id") val comment_id: String?,
    @SerializedName("user") val user: String?,
    @SerializedName("comment_text") val comment_text: String?,
    @SerializedName("create_time") val create_time: String?,
    @SerializedName("status") val status: String?
)
