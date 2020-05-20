package ml.mylittlebackend.jji6wk.data.db.album

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface AlbumDAO {
    @Query("SELECT * FROM album")
    fun getAllAlbum(): List<RoomAlbum>

    @Query("SELECT * FROM album WHERE name LIKE :filterText")
    fun findAlbums(filterText: String): List<RoomAlbum>

    @Query("SELECT * FROM image WHERE albumId = :albumId")
    fun getImagesInAlbum(albumId: String): List<RoomImage>

    @Insert(onConflict = REPLACE)
    fun addAlbum(roomAlbum: RoomAlbum)

    @Insert(onConflict = REPLACE)
    fun addImage(roomImage: RoomImage)


}