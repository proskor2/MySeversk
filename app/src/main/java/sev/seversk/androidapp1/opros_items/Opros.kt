package sev.seversk.androidapp1.opros_items

import java.sql.ClientInfoStatus

class Opros (
    val id: Int,
    val name_questionnaire: String,
    val text_before: String,
    val text_after: String,
    val status: String,
    val questionCount: Int
)