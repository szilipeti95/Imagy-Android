package ml.mylittlebackend.jji6wk.data.network

import ml.mylittlebackend.jji6wk.data.network.model.NetworkUserResult
import retrofit2.http.GET

interface UserAPI {

    @GET("/user/self")
    suspend fun getAuthenticatedUser(): NetworkUserResult
}