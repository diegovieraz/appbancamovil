package com.diegoviera.appbancamovil.data.network

import com.diegoviera.appbancamovil.data.model.ProductoModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductoApiClient {

    @GET("/productos/{id}")
    suspend fun obtenerProductos(
        @Path("id") id: String
    ): Response<List<ProductoModel>>

    @GET("/actualizarproductos/{id}")
    suspend fun actualizarProductos(
        @Path("id") id: String
    ): Response<List<ProductoModel>>

}