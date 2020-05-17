package ml.mylittlebackend.jji6wk.domain.interactor

import ml.mylittlebackend.jji6wk.data.db.DiskDataSource
import ml.mylittlebackend.jji6wk.data.network.NetworkDataSource
import javax.inject.Inject

class AuthInteractor @Inject constructor(
    private val diskDataSource: DiskDataSource,
    private val networkDataSource: NetworkDataSource
) {
    fun login() {

    }

    fun logout() {

    }

    suspend fun guest(): Boolean {
        val result = networkDataSource.sendGuest()
        return result != null
    }
}