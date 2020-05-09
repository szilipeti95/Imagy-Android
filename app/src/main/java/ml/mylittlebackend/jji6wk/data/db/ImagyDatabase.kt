package ml.mylittlebackend.jji6wk.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ml.mylittlebackend.jji6wk.data.db.album.AlbumDAO

@Database(
    exportSchema = false,
    version = 1,
    entities = [
    ]
)
abstract class ImagyDatabase: RoomDatabase() {
    abstract fun albumDao(): AlbumDAO
}