package ml.mylittlebackend.jji6wk.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkAuthRequest(
    val username: String,
    val password: String
)