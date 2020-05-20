package ml.mylittlebackend.jji6wk.screens.login

sealed class LoginViewState

object Login : LoginViewState()

object LoginSuccess: LoginViewState()

data class LoginError(val message: String = "") : LoginViewState()


