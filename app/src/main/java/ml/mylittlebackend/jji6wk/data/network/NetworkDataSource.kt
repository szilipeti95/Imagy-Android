package ml.mylittlebackend.jji6wk.data.network

import android.net.Network
import android.widget.TimePicker
import ml.mylittlebackend.jji6wk.data.network.model.NetworkAuthRequest
import ml.mylittlebackend.jji6wk.data.network.model.NetworkDefaultResult
import ml.mylittlebackend.jji6wk.data.network.model.toDomainModel
import ml.mylittlebackend.jji6wk.domain.model.Album
import ml.mylittlebackend.jji6wk.domain.model.Image
import ml.mylittlebackend.jji6wk.domain.model.User
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkDataSource @Inject constructor(
    private val albumAPI: AlbumAPI,
    private val authAPI: AuthAPI,
    private val userAPI: UserAPI
) {
    private inline fun <reified T> fetch(action: () -> T?): T? {
        return try {
            action()
        } catch (e: IOException) {
            Timber.d("Network fetch failed")
            Timber.d(e)
            return null
        } catch (e: HttpException) {
            Timber.d("Network fetch failed")
            Timber.d(e)
            return null
        } catch (e: Exception) {
            Timber.d(e)
            return null
        }
    }

    suspend fun getAlbums(): List<Album>? {
        return fetch {
            albumAPI.getAlbums().map { it.toDomainModel() }
        }
    }

    suspend fun getOwnAlbums(): List<Album>? {
        return fetch {
            albumAPI.getOwnAlbums().map { it.toDomainModel() }
        }
    }

    suspend fun getAlbumImages(albumId: String): List<Image>? {
        return fetch {
            albumAPI.getImages(albumId = albumId).map { it.toDomainModel(albumId = albumId) }
        }
    }

    suspend fun getCurrentUser(): User? {
        return fetch {
            userAPI.getAuthenticatedUser().toDomainModel()
        }
    }

    suspend fun sendGuest(): NetworkDefaultResult? {
        return fetch {
            authAPI.getGuest()
        }
    }

    suspend fun sendUser(user: NetworkAuthRequest): NetworkDefaultResult? {
        return fetch {
            authAPI.postLogin(user)
        }
    }

    suspend fun sendLogout(): NetworkDefaultResult? {
        return fetch {
            authAPI.postLogout()
        }
    }
}