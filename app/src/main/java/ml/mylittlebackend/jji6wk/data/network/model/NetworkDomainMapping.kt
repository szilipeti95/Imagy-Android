package ml.mylittlebackend.jji6wk.data.network.model

import android.annotation.SuppressLint
import ml.mylittlebackend.jji6wk.domain.model.Album
import ml.mylittlebackend.jji6wk.domain.model.Image
import ml.mylittlebackend.jji6wk.domain.model.User
import java.text.DateFormatSymbols
import java.text.SimpleDateFormat
import java.util.*


@SuppressLint("SimpleDateFormat")
fun NetworkAlbumResult.toDomainModel(): Album {
    return Album(
        id = id,
        name = name,
        author = author,
        likeCount = likeCount,
        tags = tags,
        thumbnailUri = thumbnailUri,
        creationDate = SimpleDateFormat("yyyy.MM.dd HH:mm").format(Date(creationDate))
    )
}

fun NetworkImageResult.toDomainModel(albumId: Int): Image {
    return Image(
        imageUri = imageUri,
        albumId = albumId
    )
}

fun NetworkUserResult.toDomainModel(): User {
    return User(
        email = email,
        username = username,
        password = password,
        likedCount = likedCount
    )
}