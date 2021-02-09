package sev.seversk.androidapp1.emergency

import com.google.gson.annotations.SerializedName

data class Szo (
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("type") val type: String,
    @SerializedName("address") val address: String,
    @SerializedName("phones") val phones: Array<String>,
    @SerializedName("email") val email: String,
    @SerializedName("site") val site: String,
    @SerializedName("employees") val employees: Array<employees>,
    @SerializedName("coords") val coords: Array<coords>
)

data class employees(
    @SerializedName("id")  val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("position") val position: String,
    @SerializedName("photo") val photo: String
)

data class coords(
    @SerializedName("id") val id: Int,
    @SerializedName("longitude") val longitude: Double,
    @SerializedName("latitude")  val latitude: Double
)