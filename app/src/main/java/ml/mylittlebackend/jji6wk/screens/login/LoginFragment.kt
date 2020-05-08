package ml.mylittlebackend.jji6wk.screens.login

import android.os.Bundle
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import ml.mylittlebackend.jji6wk.R

class LoginFragment : RainbowCakeFragment<LoginViewState, LoginViewModel>() {
    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.login_fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun render(viewState: LoginViewState) {
        
    }
}
