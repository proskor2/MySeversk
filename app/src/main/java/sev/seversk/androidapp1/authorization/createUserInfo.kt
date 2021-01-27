package sev.seversk.androidapp1.authorization

import com.google.gson.annotations.SerializedName

data class createUserInfo (
    @SerializedName("id") val id: Int?,
    @SerializedName("firstName") val firstName: String?,
    @SerializedName("birthday") val birhtday: String?,
    @SerializedName("gender") val gender: Int?,
    @SerializedName("token") val token: String?,
    @SerializedName("phonenumber") val phonenumber: String?
)