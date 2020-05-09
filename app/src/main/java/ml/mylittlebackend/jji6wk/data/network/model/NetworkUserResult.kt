package ml.mylittlebackend.jji6wk.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class NetworkUserResult(
    val email: String,
    val username: String,
    val password: String,
    val likedCount: Int,
    val profileImageUri: String?
)