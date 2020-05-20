package ml.mylittlebackend.jji6wk.domain.interactor

import ml.mylittlebackend.jji6wk.data.db.DiskDataSource
import ml.mylittlebackend.jji6wk.data.network.NetworkDataSource
import ml.mylittlebackend.jji6wk.domain.model.Album
import ml.mylittlebackend.jji6wk.domain.model.Image
import javax.inject.Inject

class AlbumInteractor @Inject constructor(
    private val diskDataSource: DiskDataSource,
    private val networkDataSource: NetworkDataSource
) {
    suspend fun getAllAlbum(): List<Album>? {
        val albums = networkDataSource.getAlbums()
        albums?.forEach {
            diskDataSource.saveAlbum(it)
        }
        return albums
    }
    suspend fun findAlbums(filterText: String): List<Album>? {
        return diskDataSource.findAlbums(filterText = filterText)
    }

    suspend fun getAlbumImages(albumId: String): List<Image>? {

        var images: List<Image>? = diskDataSource.getImagesInAlbum(albumId = albumId)
        if (images?.count() == 0) {
            images = networkDataSource.getAlbumImages(albumId = albumId)
            images?.forEach {
                diskDataSource.saveImage(image = it, albumId = albumId)
            }
        }
        return images
    }

    suspend fun getOwnAlbum(): List<Album>? {
        return networkDataSource.getOwnAlbums()
    }
}