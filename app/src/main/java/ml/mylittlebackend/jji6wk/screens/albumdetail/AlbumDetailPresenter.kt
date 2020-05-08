package ml.mylittlebackend.jji6wk.screens.albumdetail

import ml.mylittlebackend.jji6wk.domain.interactor.AlbumInteractor
import javax.inject.Inject

class AlbumDetailPresenter @Inject constructor(
    private val albumInteractor: AlbumInteractor
) {
}