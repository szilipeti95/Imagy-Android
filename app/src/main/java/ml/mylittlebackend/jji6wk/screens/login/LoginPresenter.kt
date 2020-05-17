package ml.mylittlebackend.jji6wk.screens.login

import co.zsmb.rainbowcake.withIOContext
import ml.mylittlebackend.jji6wk.data.network.model.NetworkAuthRequest
import ml.mylittlebackend.jji6wk.domain.interactor.AuthInteractor
import javax.inject.Inject

class LoginPresenter @Inject constructor(
    private val authInteractor: AuthInteractor
) {
    suspend fun sendLogin(request: NetworkAuthRequest): Boolean = withIOContext {
        authInteractor.login(request = request)
    }

    suspend fun sendGuest(): Boolean = withIOContext {
        authInteractor.guest()
    }
}