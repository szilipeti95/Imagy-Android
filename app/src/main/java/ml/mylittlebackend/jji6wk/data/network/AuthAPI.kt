package ml.mylittlebackend.jji6wk.data.network

import ml.mylittlebackend.jji6wk.data.network.model.NetworkAuthRequest
import ml.mylittlebackend.jji6wk.data.network.model.NetworkDefaultResult
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthAPI {
    @POST("/login")
    suspend fun postLogin(@Body authRequest: NetworkAuthRequest): NetworkDefaultResult

    @POST("/register")
    suspend fun postRegister(@Body authRequest: NetworkAuthRequest): NetworkDefaultResult

    @GET("/guest")
    suspend fun getGuest(): NetworkDefaultResult
}