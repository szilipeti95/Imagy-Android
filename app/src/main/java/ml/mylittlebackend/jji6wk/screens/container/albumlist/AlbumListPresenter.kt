package ml.mylittlebackend.jji6wk.screens.container.albumlist

import co.zsmb.rainbowcake.withIOContext
import ml.mylittlebackend.jji6wk.domain.interactor.AlbumInteractor
import ml.mylittlebackend.jji6wk.domain.model.Album
import javax.inject.Inject

class AlbumListPresenter @Inject constructor(
    private val albumInteractor: AlbumInteractor
) {
    suspend fun getAllAlbums(): List<Album> = withIOContext {
        albumInteractor.getAllAlbum() ?: emptyList()
    }

    suspend fun findAlbum(filterText: String): List<Album> = withIOContext {
        albumInteractor.findAlbums(filterText = filterText) ?: emptyList()
    }
}