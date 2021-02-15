package sev.seversk.androidapp1.remont

import sev.seversk.androidapp1.emergency.coords

data class roads(
    val id: Int,
    val title: String,
    val year: String,
    val area: String,
    val start: String,
    val finish: String,
    val length: String,
    val cost: String,
    val status: String,
    val dateBegin: String,
    val dateEnd: String,
    val coords: List<coords>
)
