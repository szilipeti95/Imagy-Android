package ml.mylittlebackend.jji6wk.screens.userdetail

sealed class UserDetailViewState

object Loading: UserDetailViewState()

data class UserLoaded(
    val username: String
): UserDetailViewState()