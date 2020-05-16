package ml.mylittlebackend.jji6wk.screens.container.userdetail

import co.zsmb.rainbowcake.base.JobViewModel
import javax.inject.Inject

class UserDetailViewModel @Inject constructor(
    private val userDetailPresenter: UserDetailPresenter
): JobViewModel<UserDetailViewState>(Loading) {

}

