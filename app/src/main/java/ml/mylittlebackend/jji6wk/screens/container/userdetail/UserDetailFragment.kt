package ml.mylittlebackend.jji6wk.screens.container.userdetail

import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.navigator
import kotlinx.android.synthetic.main.album_list_fragment.*
import kotlinx.android.synthetic.main.user_detail_fragment.*

import ml.mylittlebackend.jji6wk.R
import ml.mylittlebackend.jji6wk.domain.model.Album
import ml.mylittlebackend.jji6wk.screens.albumdetail.AlbumDetailFragment
import ml.mylittlebackend.jji6wk.screens.container.AlbumAdapter

class UserDetailFragment : RainbowCakeFragment<UserDetailViewState, UserDetailViewModel>(), AlbumAdapter.Listener {

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.user_detail_fragment

    private lateinit var albumAdapter: AlbumAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        albumAdapter = AlbumAdapter()
        albumAdapter.listener = this
    }

    override fun render(viewState: UserDetailViewState) {
    }

    override fun onStart() {
        super.onStart()

        val albumList: List<Album> = listOf(
            Album(
                id = 1,
                name = "Own Album 1",
                author = "Own User 1",
                likeCount = 0,
                tags = listOf(),
                creationDate = "Yesterday"
            ),
            Album(
                id = 2,
                name = "Own Album 2",
                author = "Own User 1",
                likeCount = 0,
                tags = listOf(),
                creationDate = "Yesterday"
            )
        )
        albumAdapter.submitList(albumList)
        userRecyclerView.adapter = albumAdapter
    }

    override fun onAlbumClicked(album: Album) {
        navigator?.add(AlbumDetailFragment())
    }

}
