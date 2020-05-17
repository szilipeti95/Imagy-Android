package ml.mylittlebackend.jji6wk.screens.albumdetail

import co.zsmb.rainbowcake.base.JobViewModel
import javax.inject.Inject

class AlbumDetailViewModel @Inject constructor(
    private val albumDetailPresenter: AlbumDetailPresenter
): JobViewModel<AlbumDetailViewState>(Loading) {
    fun load(albumId: String) = execute {
        viewState = AlbumDetailsReady(albumDetailPresenter.loadImageUris(albumId = albumId))
    }
}
