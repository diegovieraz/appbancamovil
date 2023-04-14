package com.diegoviera.appbancamovil.data.network

import com.diegoviera.appbancamovil.data.model.ProductoModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductoService @Inject constructor(
    private val api: ProductoApiClient
) {
    suspend fun getProducts(id: String): List<ProductoModel> {
        return withContext(Dispatchers.IO) {
            val response = api.obtenerProductos(id)
            response.body() ?: emptyList()
        }
    }

    suspend fun refreshProducts(id: String): List<ProductoModel> {
        return withContext(Dispatchers.IO) {
            val response = api.actualizarProductos(id)
            response.body() ?: emptyList()
        }
    }

}