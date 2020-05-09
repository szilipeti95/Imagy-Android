package ml.mylittlebackend.jji6wk.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkAlbumResult(
    val id: Int,
    val name: String,
    val author: String,
    val likeCount: Int,
    val tags: List<String>,
    val creationDate: Long
)