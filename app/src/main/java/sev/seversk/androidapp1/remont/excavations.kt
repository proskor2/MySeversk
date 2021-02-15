package sev.seversk.androidapp1.remont

import sev.seversk.androidapp1.emergency.coords

data class excavations(
    val id: Int,
    val dateOrder: String,
    val numberOrder: String,
    val renewalOrder: String,
    val customer: String,
    val contact: String,
    val contactPosition: String,
    val contactPhone: String,
    val location: String,
    val type: String,
    val nature: String,
    val start: String,
    val finish: String,
    val recovery: String,
    val comments: String,
    val status: String,
    val coords: List<coords>
)
