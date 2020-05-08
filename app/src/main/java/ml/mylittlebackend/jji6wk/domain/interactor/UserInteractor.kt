package ml.mylittlebackend.jji6wk.domain.interactor

import ml.mylittlebackend.jji6wk.domain.model.User

class UserInteractor {
    fun getUser(): User {
        return User(email = "Dummy Email",
                    username = "Dummy Username",
                    password = "Dummy Password")
    }
}