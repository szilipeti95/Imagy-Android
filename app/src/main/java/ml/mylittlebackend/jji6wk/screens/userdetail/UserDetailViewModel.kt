package ml.mylittlebackend.jji6wk.screens.userdetail

import co.zsmb.rainbowcake.base.JobViewModel
import javax.inject.Inject

class UserDetailViewModel @Inject constructor(
    private val userDetailPresenter: UserDetailPresenter
): JobViewModel<UserDetailViewState>(Loading) {

}

