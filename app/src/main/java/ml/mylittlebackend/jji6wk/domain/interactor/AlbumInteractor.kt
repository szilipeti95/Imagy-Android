package ml.mylittlebackend.jji6wk.domain.interactor

import ml.mylittlebackend.jji6wk.data.db.DiskDataSource
import ml.mylittlebackend.jji6wk.data.network.NetworkDataSource
import ml.mylittlebackend.jji6wk.domain.model.Album
import javax.inject.Inject

class AlbumInteractor @Inject constructor(
    private val diskDataSource: DiskDataSource,
    private val networkDataSource: NetworkDataSource
) {
    suspend fun getAllAlbum(): List<Album>? {
        return networkDataSource.getAlbums()
    }

    fun addAlbum(album: Album) {

    }

    fun deleteAlbum(album: Album) {

    }

    fun getImage(fromUri: String) {

    }

    fun addImage() {

    }

    fun getOwnAlbum(): List<Album> {
        return listOf()
    }

    fun likeAlbum(albumId: Int) {

    }

    fun dislikeAlbum(albumId: Int) {

    }
}