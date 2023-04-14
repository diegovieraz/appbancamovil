package com.diegoviera.appbancamovil.data.network

import com.diegoviera.appbancamovil.data.model.DetalleProductoModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovimientoService @Inject constructor(
    private val api: MovimientoApiClient
) {
    suspend fun getMovements(id: String): DetalleProductoModel {
        val empty = DetalleProductoModel(0,0,"",null)
        return withContext(Dispatchers.IO) {
            val response = api.obtenerMovimientos(id)
            response.body() ?: empty
        }
    }
}