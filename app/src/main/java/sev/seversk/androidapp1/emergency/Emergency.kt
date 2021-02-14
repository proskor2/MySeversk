package sev.seversk.androidapp1.emergency

data class Emergency (
    val id: Int,
    val title: String,
    val type: String,
    val address: String,
    val phones: List<String>,
    val email: String,
    val site: String,
    val employees: List<employeesemerg>,
    val coords: List<coordsem>
    )

data class employeesemerg(
        val id: Int,
        val name: String,
        val position: String,
        val photo: String
)

data class coordsem(
        val id: Int,
        val latitude: String,
        val longitude: String
    )