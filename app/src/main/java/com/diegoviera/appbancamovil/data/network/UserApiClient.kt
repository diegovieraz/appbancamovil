package com.diegoviera.appbancamovil.data.network

import com.diegoviera.appbancamovil.data.model.UserModel
import retrofit2.Response
import retrofit2.http.GET

interface UserApiClient {

    @GET("/.json")
    suspend fun getLogin(): Response<UserModel>

}