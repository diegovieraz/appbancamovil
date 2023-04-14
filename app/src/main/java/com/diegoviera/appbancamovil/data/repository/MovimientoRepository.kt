package com.diegoviera.appbancamovil.data.repository

import com.diegoviera.appbancamovil.data.model.DetalleProductoModel
import com.diegoviera.appbancamovil.data.model.MovimientoProvider
import com.diegoviera.appbancamovil.data.network.MovimientoService
import javax.inject.Inject

class MovimientoRepository @Inject constructor(
    private val api: MovimientoService,
    private val movimientoProvider: MovimientoProvider
) {
    suspend fun getMovements(id: String): DetalleProductoModel {
        val response = api.getMovements(id)
        movimientoProvider.response = response
        return response
    }
}