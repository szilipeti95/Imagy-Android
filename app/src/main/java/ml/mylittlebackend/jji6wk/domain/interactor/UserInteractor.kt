package ml.mylittlebackend.jji6wk.domain.interactor

import ml.mylittlebackend.jji6wk.domain.model.User
import javax.inject.Inject

class UserInteractor @Inject constructor() {
    fun getUser(): User {
        return User(email = "Dummy Email",
                    username = "Dummy Username",
                    password = "Dummy Password")
    }
}