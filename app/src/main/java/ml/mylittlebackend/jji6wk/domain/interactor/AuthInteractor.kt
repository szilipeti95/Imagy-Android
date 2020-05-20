package ml.mylittlebackend.jji6wk.domain.interactor

import ml.mylittlebackend.jji6wk.data.db.DiskDataSource
import ml.mylittlebackend.jji6wk.data.network.NetworkDataSource
import ml.mylittlebackend.jji6wk.data.network.model.NetworkAuthRequest
import javax.inject.Inject

class AuthInteractor @Inject constructor(
    private val diskDataSource: DiskDataSource,
    private val networkDataSource: NetworkDataSource
) {
    suspend fun login(request: NetworkAuthRequest): Boolean {
        return networkDataSource.sendUser(request) != null
    }

    suspend fun logout() {
        networkDataSource.sendLogout()
    }

    suspend fun guest(): Boolean {
        val result = networkDataSource.sendGuest()
        return result != null
    }
}