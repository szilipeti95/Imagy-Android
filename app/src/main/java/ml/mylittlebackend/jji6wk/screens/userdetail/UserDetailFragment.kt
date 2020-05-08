package ml.mylittlebackend.jji6wk.screens.userdetail

import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory

import ml.mylittlebackend.jji6wk.R

class UserDetailFragment : RainbowCakeFragment<UserDetailViewState, UserDetailViewModel>() {

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.user_detail_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun render(viewState: UserDetailViewState) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
