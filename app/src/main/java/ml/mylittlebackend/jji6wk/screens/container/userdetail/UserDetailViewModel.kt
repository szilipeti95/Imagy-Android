package ml.mylittlebackend.jji6wk.screens.container.userdetail

import co.zsmb.rainbowcake.base.JobViewModel
import ml.mylittlebackend.jji6wk.domain.model.User
import javax.inject.Inject

class UserDetailViewModel @Inject constructor(
    private val userDetailPresenter: UserDetailPresenter
): JobViewModel<UserDetailViewState>(Loading) {
    fun load() = execute {
        viewState = UserLoaded(
            user = userDetailPresenter.getUserData()
        )
    }

    fun loadAlbum(user: User) = execute {
        viewState = UserAndAlbumsLoaded(
            user = user,
            albums = userDetailPresenter.getUserAlbums()
        )
    }

    fun logout() = execute {
        userDetailPresenter.logout()
        viewState = Logout
    }
}

