package ml.mylittlebackend.jji6wk.screens.albumdetail

import co.zsmb.rainbowcake.withIOContext
import ml.mylittlebackend.jji6wk.domain.interactor.AlbumInteractor
import ml.mylittlebackend.jji6wk.domain.model.Image
import javax.inject.Inject

class AlbumDetailPresenter @Inject constructor(
    private val albumInteractor: AlbumInteractor
) {
    suspend fun loadImageUris(albumId: String): List<Image> = withIOContext {
        albumInteractor.getAlbumImages(albumId = albumId) ?: emptyList()
    }
}