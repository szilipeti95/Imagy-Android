package ml.mylittlebackend.jji6wk.data.album

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface AlbumDAO {
    @Query("SELECT * FROM album")
    fun getAllAlbum(): List<RoomAlbum>

    @Query("SELECT * FROM image WHERE albumId = :albumId")
    fun getImagesInAlbum(albumId: Int): List<RoomImage>

    @Insert(onConflict = REPLACE)
    fun addAlbum(roomAlbum: RoomAlbum)

    @Insert(onConflict = REPLACE)
    fun addImage(roomImage: RoomImage)


}