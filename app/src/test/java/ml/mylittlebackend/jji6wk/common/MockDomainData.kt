package ml.mylittlebackend.jji6wk.common

import ml.mylittlebackend.jji6wk.domain.model.Album
import ml.mylittlebackend.jji6wk.domain.model.Image
import ml.mylittlebackend.jji6wk.domain.model.User

val MOCK_ALL_ALBUMS = listOf(Album(
    id = "random_id",
    name = "album name",
    author = "album author",
    isLiked = false,
    likeCount = 0,
    thumbnailUri = null,
    tags = listOf("tag1", "tag2"),
    creationDate = "1234"
))

val MOCK_OWN_ALBUMS = listOf(Album(
    id = "random_id",
    name = "album name",
    author = "album author",
    isLiked = false,
    likeCount = 0,
    thumbnailUri = null,
    tags = listOf("tag1", "tag2"),
    creationDate = "1234"
))

val MOCK_ALBUM_IMAGES = listOf<Image>(
    Image(
        albumId = "album_id",
        imageUri = "image_uri"
    )
)

val MOCK_CURRENT_USER = User(
    email = "mock_email",
    username = "mock_username",
    likedCount = 0
)