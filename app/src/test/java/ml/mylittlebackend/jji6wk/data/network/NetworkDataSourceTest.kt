package ml.mylittlebackend.jji6wk.data.network

import com.google.common.truth.Truth.assertThat
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import ml.mylittlebackend.jji6wk.common.MOCK_ALBUM_IMAGES
import ml.mylittlebackend.jji6wk.common.MOCK_ALL_ALBUMS
import ml.mylittlebackend.jji6wk.common.MOCK_CURRENT_USER
import ml.mylittlebackend.jji6wk.common.MOCK_OWN_ALBUMS
import org.junit.Test

class NetworkDataSourceTest {

    private val albumAPI: AlbumAPI = mockk()
    private val userAPI: UserAPI = mockk()
    private val authAPI: AuthAPI = mockk()
    private val networkDataSource = NetworkDataSource(albumAPI, authAPI, userAPI)

    @Test
    fun `getAlbums response`() = runBlocking {
        val response = networkDataSource.getAlbums()

        assertThat(response).isEqualTo(MOCK_ALL_ALBUMS)
    }

    @Test
    fun `getImages response`() = runBlocking {
        val response = networkDataSource.getAlbumImages(albumId = "mock_id")

        assertThat(response).isEqualTo(MOCK_ALBUM_IMAGES)
    }

    @Test
    fun `getOwnAlbums response`() = runBlocking {
        val response = networkDataSource.getOwnAlbums()

        assertThat(response).isEqualTo(MOCK_OWN_ALBUMS)
    }

    @Test
    fun `getCurrentUser response`() = runBlocking {
        val response = networkDataSource.getCurrentUser()

        assertThat(response).isEqualTo(MOCK_CURRENT_USER)
    }
}