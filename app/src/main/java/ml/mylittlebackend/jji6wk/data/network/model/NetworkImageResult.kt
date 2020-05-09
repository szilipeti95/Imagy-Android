package ml.mylittlebackend.jji6wk.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkImageResult(
    val imageUri: String
)