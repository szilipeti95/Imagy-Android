package ml.mylittlebackend.jji6wk.domain.interactor

import ml.mylittlebackend.jji6wk.data.db.DiskDataSource
import ml.mylittlebackend.jji6wk.data.network.NetworkDataSource
import ml.mylittlebackend.jji6wk.domain.model.User
import javax.inject.Inject

class UserInteractor @Inject constructor(
    diskDataSource: DiskDataSource,
    networkDataSource: NetworkDataSource
) {
    fun getUser(): User {
        return User(email = "Dummy Email",
                    username = "Dummy Username",
                    password = "Dummy Password",
                    likedCount = 0)
    }
}