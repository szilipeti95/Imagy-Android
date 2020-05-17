package ml.mylittlebackend.jji6wk.screens.container.albumlist

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.navigator
import kotlinx.android.synthetic.main.album_list_fragment.*
import ml.mylittlebackend.jji6wk.R
import ml.mylittlebackend.jji6wk.domain.model.Album
import ml.mylittlebackend.jji6wk.screens.albumdetail.AlbumDetailFragment
import ml.mylittlebackend.jji6wk.screens.container.AlbumAdapter

class AlbumListFragment : RainbowCakeFragment<AlbumListViewState, AlbumListViewModel>(), AlbumAdapter.Listener {
    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.album_list_fragment

    private lateinit var albumAdapter: AlbumAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        albumAdapter = AlbumAdapter(registeredUser = true)
        albumAdapter.listener = this

        searchView.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                s?.let {
                    viewModel.search(text = it.toString())
                }
            }

        })
    }

    override fun onStart() {
        super.onStart()

        viewModel.load()

    }

    override fun render(viewState: AlbumListViewState) {
        when (viewState) {
            is AlbumListLoaded -> {
                showAlbumList(viewState.data)
            }
        }
    }

    private fun showAlbumList(albumList: List<Album>) {
        albumAdapter.submitList(albumList)
        albumListRecyclerView.adapter = albumAdapter
    }

    override fun onAlbumClicked(album: Album) {
        navigator?.add(AlbumDetailFragment.newInstance(albumId = album.id, albumName = album.name))
    }

    override fun onHeartClicked(itemView: View, album: Album) {

    }
}
