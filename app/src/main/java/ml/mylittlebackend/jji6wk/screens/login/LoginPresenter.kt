package ml.mylittlebackend.jji6wk.screens.login

import co.zsmb.rainbowcake.withIOContext
import ml.mylittlebackend.jji6wk.domain.interactor.AuthInteractor
import javax.inject.Inject

class LoginPresenter @Inject constructor(
    private val authInteractor: AuthInteractor
) {
    suspend fun sendLogin(): Boolean = withIOContext {
        authInteractor.guest()
    }

    suspend fun sendGuest(): Boolean = withIOContext {
        authInteractor.guest()
    }
}