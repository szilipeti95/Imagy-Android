package ml.mylittlebackend.jji6wk.data.db

import ml.mylittlebackend.jji6wk.domain.model.Album
import ml.mylittlebackend.jji6wk.domain.model.Image

val DISK_MOCK_ALBUM = Album(
    id = "random_id",
    name = "album name",
    author = "album author",
    isLiked = false,
    likeCount = 0,
    thumbnailUri = null,
    tags = listOf("tag1", "tag2"),
    creationDate = "1234"
)

val DISK_MOCK_IMAGE = Image(
    imageUri = "random image uri",
    albumId = "random_id"
)