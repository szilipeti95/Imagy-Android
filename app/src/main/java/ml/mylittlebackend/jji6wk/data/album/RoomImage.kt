package ml.mylittlebackend.jji6wk.data.album

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

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
    val id: Int,
    val albumId: Int,
    val imageUri: String
)