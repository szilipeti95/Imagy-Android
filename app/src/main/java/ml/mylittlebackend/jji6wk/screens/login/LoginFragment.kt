package ml.mylittlebackend.jji6wk.screens.login

import android.os.Bundle
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.navigator
import kotlinx.android.synthetic.main.login_fragment.*
import ml.mylittlebackend.jji6wk.R
import ml.mylittlebackend.jji6wk.screens.container.ContainerFragment
import ml.mylittlebackend.jji6wk.screens.container.albumlist.AlbumListFragment

class LoginFragment : RainbowCakeFragment<LoginViewState, LoginViewModel>() {
    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.login_fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        loginButton.setOnClickListener {
            navigator?.add(ContainerFragment())
        }

        guestButton.setOnClickListener {
            viewModel.loginGuest()
        }
    }

    override fun render(viewState: LoginViewState) {
        when (viewState) {
            LoginSuccess -> {
                navigator?.add(ContainerFragment())
            }
        }
    }
}
