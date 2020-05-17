package ml.mylittlebackend.jji6wk.screens.albumdetail

import ml.mylittlebackend.jji6wk.domain.model.Image

sealed class AlbumDetailViewState

object Loading : AlbumDetailViewState()

data class AlbumDetailsReady(val images: List<Image>) : AlbumDetailViewState()
