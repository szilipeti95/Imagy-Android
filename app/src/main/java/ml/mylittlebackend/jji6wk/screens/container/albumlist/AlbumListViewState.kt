package ml.mylittlebackend.jji6wk.screens.container.albumlist

import ml.mylittlebackend.jji6wk.domain.model.Album

sealed class AlbumListViewState

object Loading : AlbumListViewState()

data class AlbumListLoaded(val data: List<Album> = listOf()) : AlbumListViewState()
