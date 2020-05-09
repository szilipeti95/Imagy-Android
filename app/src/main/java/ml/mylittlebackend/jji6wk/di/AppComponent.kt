package ml.mylittlebackend.jji6wk.di

import co.zsmb.rainbowcake.dagger.RainbowCakeComponent
import co.zsmb.rainbowcake.dagger.RainbowCakeModule
import dagger.Component
import ml.mylittlebackend.jji6wk.data.db.RoomModule
import ml.mylittlebackend.jji6wk.data.network.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RainbowCakeModule::class,
        ApplicationModule::class,
        ViewModelModule::class,
        RoomModule::class,
        NetworkModule::class
    ]
)
interface AppComponent : RainbowCakeComponent