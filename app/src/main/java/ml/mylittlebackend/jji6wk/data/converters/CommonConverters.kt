package ml.mylittlebackend.jji6wk.data.converters

import androidx.room.TypeConverter
import java.util.*

class CommonConverters {

    @TypeConverter
    fun uuidToString(value: UUID?): String? {
        return value?.toString()
    }

    @TypeConverter
    fun stringToUuid(value: String?): UUID? {
        value ?: return null
        return UUID.fromString(value)
    }
}