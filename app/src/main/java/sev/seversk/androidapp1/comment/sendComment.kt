package sev.seversk.androidapp1.comment

import com.google.gson.annotations.SerializedName

data class sendComment (
    @SerializedName("comment_id") val comment_id: Int?,
    @SerializedName("user") val user: String?,
    @SerializedName("create_time") val create_time: String?,
    @SerializedName("status") val status: String?,
    @SerializedName("comment_text") val comment_text: String,
    @SerializedName("owner_id") val owner_id: String?,
    @SerializedName("owner_name") val owner_name: String?
)