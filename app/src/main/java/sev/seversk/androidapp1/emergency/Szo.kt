package sev.seversk.androidapp1.emergency

data class Szo (
    val id: Int,
    val title: String,
    val type: String,
    val address: String,
    val phones: ArrayList<String>,
    val email: String,
    val site: String,
    val employees: ArrayList<employees>,
    val coords: ArrayList<coords>
)

data class employees(
    val id: Int,
    val name: String,
    val position: String,
    val photo: String
)

data class coords(
    val id: Int,
    val longitude: Double,
    val latitude: Double
)