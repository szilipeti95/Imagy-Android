package ml.mylittlebackend.jji6wk.screens.container.albumlist

import co.zsmb.rainbowcake.base.JobViewModel
import javax.inject.Inject

class AlbumListViewModel @Inject constructor(
    private val albumListPresenter: AlbumListPresenter
) : JobViewModel<AlbumListViewState>(Loading) {
}
