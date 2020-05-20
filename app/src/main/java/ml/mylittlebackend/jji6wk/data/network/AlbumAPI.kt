package ml.mylittlebackend.jji6wk.data.network

import ml.mylittlebackend.jji6wk.data.network.model.NetworkAlbumResult
import ml.mylittlebackend.jji6wk.data.network.model.NetworkDefaultResult
import ml.mylittlebackend.jji6wk.data.network.model.NetworkImageResult
import ml.mylittlebackend.jji6wk.data.network.model.NetworkNewAlbum
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface AlbumAPI {
    @POST("/album")
    suspend fun addAlbums(@Body newAlbum: NetworkNewAlbum): List<NetworkAlbumResult>

    @DELETE("/album/delete/{albumId}")
    suspend fun deleteAlbum(@Path("albumId") albumId: Int): NetworkDefaultResult

    @GET("/albums")
    suspend fun getAlbums(): List<NetworkAlbumResult>

    @GET("/album/self")
    suspend fun getOwnAlbums(): List<NetworkAlbumResult>

    @GET("/album/images/{albumId}")
    suspend fun getImages(@Path("albumId") albumId: String): List<NetworkImageResult>

    @GET("/image/{imageUri}")
    suspend fun getImage(@Path("imageUri") imageUri: String): Call<ResponseBody>

    @POST("/image/{albumId}")
    suspend fun postImage(@Path("albumId") albumId: Int, @Part imageData: MultipartBody.Part): NetworkDefaultResult

    @POST("/album/like/{albumId}")
    suspend fun postLike(@Path("albumId") albumId: Int): NetworkDefaultResult

    @POST("/album/unlike/{albumId}")
    suspend fun postUnlike(@Path("albumId") albumId: Int): NetworkDefaultResult
}