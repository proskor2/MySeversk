package sev.seversk.androidapp1.disctrict_items

import com.google.gson.annotations.SerializedName

data class District (
    @SerializedName("id") val id: Int,
    @SerializedName("number") val number: String,
    @SerializedName("area") val area: List<Int>,
    @SerializedName("deputies") val deputies: List<deputies>,
    @SerializedName("addresses") val addresses: List<String>,
    @SerializedName("coords") val coords: List<coordsdistr>
        )

data class deputies (
    val id: Int,
    val name: String,
    val photo: String,
    val timetable: String,
    val info: String,
    val position: String
        )

data class coordsdistr (
    val id: Int,
    val latitude: String,
    val longitude: String
        )




