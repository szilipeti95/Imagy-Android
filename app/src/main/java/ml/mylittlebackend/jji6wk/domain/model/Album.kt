package ml.mylittlebackend.jji6wk.domain.model

data class Album (
    val id: Int,
    val name: String,
    val author: String,
    val likeCount: Int,
    val tags: List<String>,
    val creationDate: String
)