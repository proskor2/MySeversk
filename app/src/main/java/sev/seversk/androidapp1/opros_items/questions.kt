package sev.seversk.androidapp1.opros_items

data class questions (
    val onum: Int,
    val id: Int,
    val questionnaireId: Int,
    val question: String,
    val context: String,
    val type: String,
    val validations: List<validations>,
    val variants: ArrayList<variants>,
    val answers: ArrayList<answers>,
    val isSkipped: Boolean,
    val canShowPrevious: Boolean,
    val isFinish: Boolean
)

data class validations(
    val required: Boolean,
    val minAnswer: Int,
    val maxAnswer: Int
)

data class variants(
    val id: Int,
    val answer: String,
    val isCanComment: Boolean
)

data class answers(
    val selectedVersionAnswer: Int,
    val openAnswer: String
)