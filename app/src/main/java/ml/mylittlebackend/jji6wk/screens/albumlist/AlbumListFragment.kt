package ml.mylittlebackend.jji6wk.screens.albumlist

import android.os.Bundle
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import ml.mylittlebackend.jji6wk.R

class AlbumListFragment : RainbowCakeFragment<AlbumListViewState, AlbumListViewModel>() {
    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.album_list_fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun render(viewState: AlbumListViewState) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
