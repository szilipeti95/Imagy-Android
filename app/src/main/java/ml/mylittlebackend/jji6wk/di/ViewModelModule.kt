package ml.mylittlebackend.jji6wk.di

import androidx.lifecycle.ViewModel
import co.zsmb.rainbowcake.dagger.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ml.mylittlebackend.jji6wk.screens.albumdetail.AlbumDetailViewModel
import ml.mylittlebackend.jji6wk.screens.container.ContainerViewModel
import ml.mylittlebackend.jji6wk.screens.container.albumlist.AlbumListViewModel
import ml.mylittlebackend.jji6wk.screens.login.LoginViewModel
import ml.mylittlebackend.jji6wk.screens.container.userdetail.UserDetailViewModel

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(UserDetailViewModel::class)
    abstract fun userDetailViewModel(userViewModel: UserDetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AlbumDetailViewModel::class)
    abstract fun albumDetailViewModel(albumDetailViewModel: AlbumDetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AlbumListViewModel::class)
    abstract fun albumListViewModel(albumListViewModel: AlbumListViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(ContainerViewModel::class)
    abstract fun containerViewModel(userViewModel: ContainerViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun loginViewModel(loginViewModel: LoginViewModel): ViewModel
}