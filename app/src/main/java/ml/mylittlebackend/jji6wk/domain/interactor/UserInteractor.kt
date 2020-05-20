package ml.mylittlebackend.jji6wk.domain.interactor

import ml.mylittlebackend.jji6wk.data.db.DiskDataSource
import ml.mylittlebackend.jji6wk.data.network.NetworkDataSource
import ml.mylittlebackend.jji6wk.domain.model.User
import javax.inject.Inject

class UserInteractor @Inject constructor(
    private val diskDataSource: DiskDataSource,
    private val networkDataSource: NetworkDataSource
) {
    suspend fun getUser(): User {
        val result = networkDataSource.getCurrentUser()
        return result ?: User(email = "Invalid Email",
                    username = "Invalid Username",
                    likedCount = 0)
    }
}