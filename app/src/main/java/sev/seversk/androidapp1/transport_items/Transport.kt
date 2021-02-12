package sev.seversk.androidapp1.transport_items

class Transport (
    val id: Int,
    val title: String,
    val type:String,
    val number: String,
    val length: String,
    val dateBegin: String,
    val payRules: String,
    val streetForward: List<String>,
    val streetBack: List<String>,
    val stopForward: List<String>,
    val stopBack: List<String>,
    val carrier: List<String>,
    val typeBus: List<String>
    )