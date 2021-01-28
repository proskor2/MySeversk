package sev.seversk.androidapp1.authorization

import com.google.gson.annotations.SerializedName

data class createUserInfo (
    @SerializedName("id") val id: Int?,
    @SerializedName("phone") val phone: String?,
    @SerializedName("token") val token: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("gender") val gender: Int?,
    @SerializedName("birthday") val birthday: String?
        )