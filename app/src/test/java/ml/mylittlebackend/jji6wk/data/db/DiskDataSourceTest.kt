package ml.mylittlebackend.jji6wk.data.db

import com.google.common.truth.Truth.assertThat
import io.mockk.clearAllMocks
import io.mockk.mockk
import ml.mylittlebackend.jji6wk.data.db.album.AlbumDAO
import org.junit.Before
import org.junit.Test

class DiskDataSourceTest {
    private val albumDao: AlbumDAO = mockk()
    private val diskDataSource = DiskDataSource(albumDao)

    @Before
    fun setUp() {
        clearAllMocks()
    }

    @Test
    fun `Add Album Successfully`() {
        diskDataSource.saveAlbum(album = DISK_MOCK_ALBUM)
        val albums = diskDataSource.findAlbums("")
        assertThat(albums.count()).isEqualTo(1)
    }

    @Test
    fun `Filter Text Tests`() {
        diskDataSource.saveAlbum(album = DISK_MOCK_ALBUM)
        val albums = diskDataSource.findAlbums(DISK_MOCK_ALBUM.name)
        assertThat(albums.count()).isEqualTo(1)
    }

    @Test
    fun `Add Image Successfully`() {
        diskDataSource.saveAlbum(album = DISK_MOCK_ALBUM)
        diskDataSource.saveImage(image = DISK_MOCK_IMAGE, albumId = DISK_MOCK_IMAGE.albumId)
        val images = diskDataSource.getImagesInAlbum(albumId = DISK_MOCK_IMAGE.albumId)
        assertThat(images.count()).isEqualTo(1)
    }

}