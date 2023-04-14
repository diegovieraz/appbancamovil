package com.diegoviera.appbancamovil.data.network

import com.diegoviera.appbancamovil.data.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserService @Inject constructor(
    private val api: UserApiClient
) {
    suspend fun getLogin():UserModel{
        val empty : UserModel = UserModel("",0)
        return withContext(Dispatchers.IO){
            val response = api.getLogin()
            response.body() ?: empty
        }
    }

}