package ml.mylittlebackend.jji6wk.di

import androidx.lifecycle.ViewModel
import co.zsmb.rainbowcake.dagger.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ml.mylittlebackend.jji6wk.screens.albumdetail.AlbumDetailViewModel
import ml.mylittlebackend.jji6wk.screens.albumlist.AlbumListViewModel
import ml.mylittlebackend.jji6wk.screens.login.LoginViewModel
import ml.mylittlebackend.jji6wk.screens.userdetail.UserDetailViewModel

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(UserDetailViewModel::class)
    abstract fun userDetailViewModel(userViewModel: UserDetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AlbumDetailViewModel::class)
    abstract fun albumDetailViewModel(userViewModel: AlbumDetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AlbumListViewModel::class)
    abstract fun albumListViewModel(userViewModel: AlbumListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun loginViewModel(userViewModel: LoginViewModel): ViewModel
}