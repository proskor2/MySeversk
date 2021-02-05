package sev.seversk.androidapp1.comment



data class comment (
    val title: String?,
    val comments: ArrayList<comments>
)

data class comments (
    val comment_id: String?,
    val user: String?,
    val comment_text: String?,
    val create_time: String?,
    val status: String?
        )