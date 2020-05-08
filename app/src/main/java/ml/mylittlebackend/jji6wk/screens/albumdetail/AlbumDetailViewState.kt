package ml.mylittlebackend.jji6wk.screens.albumdetail

import ml.mylittlebackend.jji6wk.domain.model.Album

sealed class AlbumDetailViewState

object Loading : AlbumDetailViewState()

data class AlbumDetailsReady(val album: Album) : AlbumDetailViewState()
