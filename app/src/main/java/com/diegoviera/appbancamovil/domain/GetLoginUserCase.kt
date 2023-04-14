package com.diegoviera.appbancamovil.domain

import com.diegoviera.appbancamovil.data.model.UserModel
import com.diegoviera.appbancamovil.data.repository.UserRepository
import javax.inject.Inject

class GetLoginUserCase @Inject constructor(
    private val repository:UserRepository
) {
    suspend operator fun invoke(user: String, password: String):UserModel? {
        return repository.getLogin(user,password)
    }
}