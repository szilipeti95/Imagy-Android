package ml.mylittlebackend.jji6wk.data.db

import ml.mylittlebackend.jji6wk.data.db.album.AlbumDAO
import ml.mylittlebackend.jji6wk.data.db.album.toDomainModel
import ml.mylittlebackend.jji6wk.data.db.album.toRoomModel
import ml.mylittlebackend.jji6wk.domain.model.Album
import ml.mylittlebackend.jji6wk.domain.model.Image
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DiskDataSource @Inject constructor(
    private val albumDAO: AlbumDAO
) {
    fun getAllAlbum(): List<Album> {
        return albumDAO.getAllAlbum().map { it.toDomainModel() }
    }

    fun getImagesInAlbum(albumId: Int): List<Image> {
        return albumDAO.getImagesInAlbum(albumId = albumId).map { it.toDomainModel() }
    }

    fun saveAlbum(album: Album) {
        albumDAO.addAlbum(album.toRoomModel())
    }

    fun saveImage(image: Image) {
        albumDAO.addImage(image.toRoomModel())
    }
}