package ml.mylittlebackend.jji6wk.domain.model

import java.util.*

data class User(
    val email: String,
    val username: String,
    val password: String,
    val likedCount: Int
)