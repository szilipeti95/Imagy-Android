package ml.mylittlebackend.jji6wk.screens.container.userdetail

import ml.mylittlebackend.jji6wk.domain.model.Album
import ml.mylittlebackend.jji6wk.domain.model.User

sealed class UserDetailViewState

object Loading: UserDetailViewState()

object Logout: UserDetailViewState()

data class UserLoaded(
    val user: User
): UserDetailViewState()

data class UserAndAlbumsLoaded(
    val user: User,
    val albums: List<Album>
): UserDetailViewState()