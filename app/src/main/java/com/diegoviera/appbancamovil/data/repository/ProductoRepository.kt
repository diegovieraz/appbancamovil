package com.diegoviera.appbancamovil.data.repository

import com.diegoviera.appbancamovil.data.model.ProductoModel
import com.diegoviera.appbancamovil.data.model.ProductoProvider
import com.diegoviera.appbancamovil.data.network.ProductoService
import javax.inject.Inject

class ProductoRepository @Inject constructor(
    private val api: ProductoService,
    private val productoProvider: ProductoProvider
) {
    suspend fun getProductos(id : String): List<ProductoModel> {
        val response = api.getProducts(id)
        productoProvider.response = response
        return response
    }

    suspend fun refreshProductos(id : String): List<ProductoModel> {
        val response = api.refreshProducts(id)
        productoProvider.response = response
        return response
    }
}