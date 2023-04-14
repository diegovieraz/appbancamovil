package com.diegoviera.appbancamovil.data.network

import com.diegoviera.appbancamovil.data.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserService @Inject constructor(
    private val api: UserApiClient
) {
    suspend fun getLogin(user: String, password: String): UserModel {
        val empty = UserModel("", 0)
        return withContext(Dispatchers.IO) {
            val response = api.iniciarSesion(user, password)
            response.body() ?: empty
        }
    }

}