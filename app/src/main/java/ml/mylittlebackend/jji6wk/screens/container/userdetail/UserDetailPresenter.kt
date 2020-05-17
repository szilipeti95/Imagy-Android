package ml.mylittlebackend.jji6wk.screens.container.userdetail

import co.zsmb.rainbowcake.withIOContext
import ml.mylittlebackend.jji6wk.domain.interactor.AlbumInteractor
import ml.mylittlebackend.jji6wk.domain.interactor.AuthInteractor
import ml.mylittlebackend.jji6wk.domain.interactor.UserInteractor
import ml.mylittlebackend.jji6wk.domain.model.Album
import ml.mylittlebackend.jji6wk.domain.model.User
import javax.inject.Inject

class UserDetailPresenter @Inject constructor(
    private val albumInteractor: AlbumInteractor,
    private val authInteractor: AuthInteractor,
    private val userInteractor: UserInteractor
) {

    suspend fun getUserData(): User = withIOContext {
        userInteractor.getUser()
    }

    suspend fun getUserAlbums(): List<Album> = withIOContext {
        albumInteractor.getOwnAlbum() ?: emptyList()
    }

    suspend fun logout() = withIOContext {
        authInteractor.logout()
    }
}