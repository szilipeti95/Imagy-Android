package ml.mylittlebackend.jji6wk.screens.container.userdetail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.navigator
import kotlinx.android.synthetic.main.album_list_fragment.*
import kotlinx.android.synthetic.main.row_album.view.*
import kotlinx.android.synthetic.main.user_detail_fragment.*

import ml.mylittlebackend.jji6wk.R
import ml.mylittlebackend.jji6wk.domain.model.Album
import ml.mylittlebackend.jji6wk.domain.model.User
import ml.mylittlebackend.jji6wk.screens.albumdetail.AlbumDetailFragment
import ml.mylittlebackend.jji6wk.screens.container.AlbumAdapter
import ml.mylittlebackend.jji6wk.screens.login.LoginFragment

class UserDetailFragment : RainbowCakeFragment<UserDetailViewState, UserDetailViewModel>(), AlbumAdapter.Listener {

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.user_detail_fragment

    private lateinit var albumAdapter: AlbumAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        logoutButton.setOnClickListener {
            viewModel.logout()
        }
    }

    override fun render(viewState: UserDetailViewState) {
        when (viewState) {
            is UserLoaded -> {
                showUserData(viewState.user)
            }
            is UserAndAlbumsLoaded -> {
                showAlbumData(viewState.albums)
            }
            is Logout -> {
                navigator?.replace(LoginFragment())
            }
        }
    }

    override fun onStart() {
        super.onStart()

        viewModel.load()
    }

    @SuppressLint("SetTextI18n")
    private fun showUserData(user: User) {
        userDetailUsernameText.text = user.username
        albumAdapter = AlbumAdapter(registeredUser = user.username != "guest")
        albumAdapter.listener = this
        userDetailLikeCountText.text = user.likedCount.toString()
        logoutButton.text = getString(R.string.user_detail_logout) + " ${user.username}"
        if (user.username == "guest") {
            userDetailYourAblums.text = getString(R.string.user_detail_guest_albums)
        } else {
            userDetailYourAblums.text = getString(R.string.user_your_albums)
            viewModel.loadAlbum(user)
        }
    }

    private fun showAlbumData(album: List<Album>) {
        albumAdapter.submitList(album)
        userRecyclerView.adapter = albumAdapter
    }

    override fun onAlbumClicked(album: Album) {
        navigator?.add(AlbumDetailFragment.newInstance(albumId = album.id, albumName = album.name))
    }

    @SuppressLint("SetTextI18n")
    override fun onHeartClicked(itemView: View, album: Album) {
        val likeString = getString(R.string.album_likes)
        if (itemView.heartButton.isLiked && album.isLiked) {
            itemView.albumLikeCount.text = "${album.likeCount} $likeString"
        } else if (itemView.heartButton.isLiked && !album.isLiked) {
            itemView.albumLikeCount.text = "${album.likeCount + 1} $likeString"
        } else if (!itemView.heartButton.isLiked && album.isLiked) {
            itemView.albumLikeCount.text = "${album.likeCount - 1} $likeString"
        } else if (!itemView.heartButton.isLiked && !album.isLiked) {
            itemView.albumLikeCount.text = "${album.likeCount} $likeString"
        }
    }

}
