package sev.seversk.androidapp1.news_items

data class News(
    val title: String,
    val preview: String,
    val photo: String,
    val description: String,
    val date: String,
    val id: Int,
    val comments_count: Int
)