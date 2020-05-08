package ml.mylittlebackend.jji6wk.screens.albumdetail

import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory

import ml.mylittlebackend.jji6wk.R

class AlbumDetailFragment : RainbowCakeFragment<AlbumDetailViewState, AlbumDetailViewModel>() {
    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.album_detail_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun render(viewState: AlbumDetailViewState) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
