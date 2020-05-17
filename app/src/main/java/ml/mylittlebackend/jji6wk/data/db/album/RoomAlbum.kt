package ml.mylittlebackend.jji6wk.data.db.album

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "album")
data class RoomAlbum (
    @PrimaryKey
    val id: String,
    val name: String,
    val author: String,
    val likeCount: Int,
    val tags: String,
    val creationDate: Long
)