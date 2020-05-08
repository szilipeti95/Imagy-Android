package ml.mylittlebackend.jji6wk.screens.login

import co.zsmb.rainbowcake.base.JobViewModel
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val loginPresenter: LoginPresenter
) : JobViewModel<LoginViewState>(Login) {
}
