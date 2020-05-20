package ml.mylittlebackend.jji6wk.screens.login

import co.zsmb.rainbowcake.base.JobViewModel
import ml.mylittlebackend.jji6wk.data.network.model.NetworkAuthRequest
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val loginPresenter: LoginPresenter
) : JobViewModel<LoginViewState>(Login) {
    fun loginGuest() = execute {
        viewState = if (loginPresenter.sendGuest()) {
            LoginSuccess
        } else {
            LoginError("Could not connect with Guest User")
        }
    }

    fun loginUser(username: String, password: String) = execute {
        val request = NetworkAuthRequest(
            username = username,
            password = password
        )
        viewState = if (loginPresenter.sendLogin(request)) {
            LoginSuccess
        } else {
            LoginError("Username or Password is incorrect")
        }
    }
}
