package sev.seversk.androidapp1.authorization

import com.google.gson.annotations.SerializedName

data class tokenInfo(
    @SerializedName("token") val token: String?,
    @SerializedName("phonenumber") val phonenumber: String?,
    @SerializedName("status") val status: String?,
    @SerializedName("code") val code: Int?
)
