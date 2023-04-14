package com.diegoviera.appbancamovil.data.network

import com.diegoviera.appbancamovil.data.model.UserModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApiClient {

    @GET("/iniciarsesion/{user}/{password}")
    suspend fun iniciarSesion(
        @Path("user") user: String,
        @Path("password") password: String
    ): Response<UserModel>

}