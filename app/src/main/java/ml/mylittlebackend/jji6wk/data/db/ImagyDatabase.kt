package ml.mylittlebackend.jji6wk.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import ml.mylittlebackend.jji6wk.data.album.AlbumDAO
import ml.mylittlebackend.jji6wk.data.converters.CommonConverters

@Database(
    exportSchema = false,
    version = 1,
    entities = [
    ]
)
@TypeConverter(
    CommonConverters::class
)
abstract class ImagyDatabase: RoomDatabase() {
    abstract fun albumDao(): AlbumDAO
}