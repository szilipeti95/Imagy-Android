package ml.mylittlebackend.jji6wk.data.db.album

import android.annotation.SuppressLint
import ml.mylittlebackend.jji6wk.domain.model.Album
import ml.mylittlebackend.jji6wk.domain.model.Image
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
fun RoomAlbum.toDomainModel(): Album {
    return Album(
        id = id,
        name = name,
        author = author,
        isLiked = isLiked == 1,
        likeCount = likeCount,
        tags = tags.split(" "),
        thumbnailUri = if (thumbnailUri == "null") null else thumbnailUri,
        creationDate = SimpleDateFormat("yyyy.MM.dd HH:mm").format(Date(creationDate))
    )
}

@SuppressLint("SimpleDateFormat")
fun Album.toRoomModel(): RoomAlbum {
    return RoomAlbum(
        id = id,
        name =  name,
        author = author,
        isLiked = if (isLiked) 1 else 0,
        likeCount = likeCount,
        tags = tags.joinToString(" "),
        thumbnailUri = thumbnailUri ?: "null",
        creationDate = SimpleDateFormat("yyyy.MM.dd HH:mm").parse(creationDate).time
    )
}

fun RoomImage.toDomainModel(): Image {
    return Image(
        imageUri = imageUri,
        albumId = albumId
    )
}

fun Image.toRoomModel(albumId: String): RoomImage {
    return RoomImage(
        id = UUID.randomUUID().toString(),
        imageUri = imageUri,
        albumId = albumId
    )
}