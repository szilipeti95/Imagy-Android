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
        likeCount = likeCount,
        tags = tags.split(" "),
        creationDate = SimpleDateFormat("yyyy.MM.dd HH:mm").format(Date(creationDate))
    )
}

@SuppressLint("SimpleDateFormat")
fun Album.toRoomModel(): RoomAlbum {
    return RoomAlbum(
        id = id,
        name =  name,
        author = author,
        likeCount = likeCount,
        tags = tags.joinToString(" "),
        creationDate = SimpleDateFormat("yyyy.MM.dd HH:mm").parse(creationDate).time
    )
}

fun RoomImage.toDomainModel(): Image {
    return Image(
        id = id,
        imageUri = imageUri,
        albumId = albumId
    )
}

fun Image.toRoomModel(): RoomImage {
    return RoomImage(
        id = id,
        imageUri = imageUri,
        albumId = albumId
    )
}