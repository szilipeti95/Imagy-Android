package ml.mylittlebackend.jji6wk.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ml.mylittlebackend.jji6wk.data.db.album.AlbumDAO
import ml.mylittlebackend.jji6wk.data.db.album.RoomAlbum
import ml.mylittlebackend.jji6wk.data.db.album.RoomImage

@Database(
    exportSchema = false,
    version = 1,
    entities = [
        RoomAlbum::class,
        RoomImage::class
    ]
)
abstract class ImagyDatabase: RoomDatabase() {
    abstract fun albumDao(): AlbumDAO
}