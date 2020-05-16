package ml.mylittlebackend.jji6wk.screens.container.userdetail

sealed class UserDetailViewState

object Loading: UserDetailViewState()

data class UserLoaded(
    val username: String
): UserDetailViewState()