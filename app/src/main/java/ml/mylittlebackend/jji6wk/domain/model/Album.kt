package ml.mylittlebackend.jji6wk.domain.model

data class Album (
    val id: String,
    val name: String,
    val author: String,
    val isLiked: Boolean,
    val likeCount: Int,
    val thumbnailUri: String?,
    val tags: List<String>,
    val creationDate: String
)