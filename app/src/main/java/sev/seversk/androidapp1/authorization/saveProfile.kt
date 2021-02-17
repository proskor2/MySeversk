package sev.seversk.androidapp1.authorization

import com.google.gson.annotations.SerializedName

data class saveProfile (
    @SerializedName("lastName") val lastName: String?,
    @SerializedName("firstName") val firstName: String?,
    @SerializedName("patronymic") val patronymic: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("phonenumber") val phonenumber: String?,
    @SerializedName("address") val address: String?,
    @SerializedName("birthday") val birthday: String?,
    @SerializedName("gender") val gender: String?
    )