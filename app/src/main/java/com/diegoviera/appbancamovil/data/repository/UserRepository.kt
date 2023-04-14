package com.diegoviera.appbancamovil.data.repository

import com.diegoviera.appbancamovil.data.model.UserModel
import com.diegoviera.appbancamovil.data.model.UserProvider
import com.diegoviera.appbancamovil.data.network.UserService
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val api: UserService,
    private val userProvider: UserProvider
) {
    suspend fun getLogin(): UserModel {
        val response = api.getLogin()
        userProvider.response = response
        return response
    }
}