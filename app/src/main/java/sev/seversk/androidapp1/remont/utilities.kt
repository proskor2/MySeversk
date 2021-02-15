package sev.seversk.androidapp1.remont

import sev.seversk.androidapp1.emergency.coords

data class utilities(
    val id: Int,
    val type: String,
    val title: String,
    val location: String,
    val service: String,
    val sector: String,
    val startPlan: String,
    val finishPlan: String,
    val startFact: String,
    val finishFact: String,
    val comments: String,
    val coords: List<coords>
)
