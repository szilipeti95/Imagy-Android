package ml.mylittlebackend.jji6wk.data.db.album

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.*

@Entity(
    tableName = "image",
    foreignKeys = [

        ForeignKey(
            entity = RoomAlbum::class,
            parentColumns = ["id"],
            childColumns = ["albumId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index("albumId")
    ]
)
class RoomImage(
    @PrimaryKey
    val id: String,
    val albumId: String,
    val imageUri: String
)