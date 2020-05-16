package ml.mylittlebackend.jji6wk.screens.albumdetail

import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import kotlinx.android.synthetic.main.album_detail_fragment.*

import ml.mylittlebackend.jji6wk.R

class AlbumDetailFragment : RainbowCakeFragment<AlbumDetailViewState, AlbumDetailViewModel>() {
    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.album_detail_fragment

    private lateinit var albumDetailAdapter: AlbumDetailAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        albumDetailAdapter = AlbumDetailAdapter()
    }

    override fun render(viewState: AlbumDetailViewState) {
    }

    override fun onStart() {
        super.onStart()

        val imageUris: List<String> = listOf(
            "image-uri-1",
            "image-uri-2",
            "image-uri-3",
            "image-uri-4",
            "image-uri-5",
            "image-uri-6",
            "image-uri-7",
            "image-uri-8"
        )
        albumDetailAdapter.submitList(imageUris)
        albumDetailRecyclerView.adapter = albumDetailAdapter
    }
}
