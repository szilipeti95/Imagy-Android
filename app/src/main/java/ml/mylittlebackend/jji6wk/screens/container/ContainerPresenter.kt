package ml.mylittlebackend.jji6wk.screens.container

import ml.mylittlebackend.jji6wk.domain.interactor.UserInteractor
import ml.mylittlebackend.jji6wk.domain.model.User
import javax.inject.Inject

class ContainerPresenter @Inject constructor(
    private val userInteractor: UserInteractor
)