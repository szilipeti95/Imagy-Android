package ml.mylittlebackend.jji6wk.screens.albumdetail

import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.extensions.applyArgs
import co.zsmb.rainbowcake.navigation.extensions.requireString
import co.zsmb.rainbowcake.navigation.navigator
import kotlinx.android.synthetic.main.album_detail_fragment.*
import kotlinx.android.synthetic.main.toolbar.*

import ml.mylittlebackend.jji6wk.R
import ml.mylittlebackend.jji6wk.domain.model.Image

class AlbumDetailFragment : RainbowCakeFragment<AlbumDetailViewState, AlbumDetailViewModel>() {
    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.album_detail_fragment

    private lateinit var albumDetailAdapter: AlbumDetailAdapter

    companion object {
        private const val ALBUM_ID = "ALBUM_ID"
        private const val ALBUM_NAME = "ALBUM_NAME"

        @Suppress("DEPRECATION")
        fun newInstance(albumId: String, albumName: String): AlbumDetailFragment {
            return AlbumDetailFragment().applyArgs {
                putString(ALBUM_ID, albumId)
                putString(ALBUM_NAME, albumName)
            }
        }
    }

    private lateinit var albumId: String
    private lateinit var albumName: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        albumId = requireArguments().requireString(ALBUM_ID)
        albumName = requireArguments().requireString(ALBUM_NAME)

        toolbar.title = albumName
        toolbar.setNavigationOnClickListener {
            navigator?.pop()
        }
        albumDetailAdapter = AlbumDetailAdapter()
    }

    override fun render(viewState: AlbumDetailViewState) {
        when(viewState) {
            is AlbumDetailsReady -> {
                albumImageUrisReady(viewState.images)
            }
        }
    }

    override fun onStart() {
        super.onStart()

        viewModel.load(albumId = albumId)
    }

    private fun albumImageUrisReady(imageUris: List<Image>) {
        albumDetailAdapter.submitList(imageUris)
        albumDetailRecyclerView.adapter = albumDetailAdapter
    }
}
