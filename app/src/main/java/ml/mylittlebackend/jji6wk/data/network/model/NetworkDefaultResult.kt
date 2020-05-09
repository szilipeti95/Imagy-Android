package ml.mylittlebackend.jji6wk.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class NetworkDefaultResult(
    val message: String
)