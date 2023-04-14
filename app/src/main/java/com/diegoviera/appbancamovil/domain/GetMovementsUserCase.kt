package com.diegoviera.appbancamovil.domain

import com.diegoviera.appbancamovil.data.model.DetalleProductoModel
import com.diegoviera.appbancamovil.data.repository.MovimientoRepository
import javax.inject.Inject

class GetMovementsUserCase @Inject constructor(
    private val repository: MovimientoRepository
) {
    suspend operator fun invoke(id: String): DetalleProductoModel? {
        return repository.getMovements(id)
    }
}