package ml.mylittlebackend.jji6wk.screens.container

import co.zsmb.rainbowcake.base.JobViewModel
import javax.inject.Inject

class ContainerViewModel @Inject constructor(
    private val containerPresenter: ContainerPresenter
) :
    JobViewModel<ContainerViewState>(ContainerReady("")) {
}