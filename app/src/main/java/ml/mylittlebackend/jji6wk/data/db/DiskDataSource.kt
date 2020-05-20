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
    fun findAlbums(filterText: String): List<Album> {
        return albumDAO.findAlbums("%$filterText%").map { it.toDomainModel() }
    }

    fun getImagesInAlbum(albumId: String): List<Image> {
        return albumDAO.getImagesInAlbum(albumId = albumId).map { it.toDomainModel() }
    }

    fun saveAlbum(album: Album) {
        albumDAO.addAlbum(album.toRoomModel())
    }

    fun saveImage(image: Image, albumId: String) {
        albumDAO.addImage(image.toRoomModel(albumId = albumId))
    }
}