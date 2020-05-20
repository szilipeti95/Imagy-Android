package ml.mylittlebackend.jji6wk.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkAlbumResult(
    val id: String,
    val name: String,
    val author: String,
    val isLiked: Boolean,
    val likeCount: Int,
    val tags: List<String>,
    val thumbnailUri: String?,
    val creationDate: Long
)