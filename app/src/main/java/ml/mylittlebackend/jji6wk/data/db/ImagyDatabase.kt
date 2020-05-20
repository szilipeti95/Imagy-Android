package ml.mylittlebackend.jji6wk.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ml.mylittlebackend.jji6wk.data.db.album.AlbumDAO
import ml.mylittlebackend.jji6wk.data.db.album.RoomAlbum
import ml.mylittlebackend.jji6wk.data.db.album.RoomImage
import ml.mylittlebackend.jji6wk.data.db.converters.CommonConverters

@Database(
    exportSchema = false,
    version = 3,
    entities = [
        RoomAlbum::class,
        RoomImage::class
    ]
)
abstract class ImagyDatabase: RoomDatabase() {
    abstract fun albumDao(): AlbumDAO
}