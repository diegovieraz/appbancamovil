package com.diegoviera.appbancamovil.domain

import com.diegoviera.appbancamovil.data.model.ProductoModel
import com.diegoviera.appbancamovil.data.repository.ProductoRepository
import javax.inject.Inject

class RefreshProductsUserCase @Inject constructor(
    private val repository: ProductoRepository
) {
    suspend operator fun invoke(id: String): List<ProductoModel>? {
        return repository.refreshProductos(id)
    }
}