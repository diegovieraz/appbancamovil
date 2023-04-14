package com.diegoviera.appbancamovil.data.network

import com.diegoviera.appbancamovil.data.model.DetalleProductoModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MovimientoApiClient {

    @GET("/movimientos/{id}")
    suspend fun obtenerMovimientos(
        @Path("id") id: String
    ): Response<DetalleProductoModel>

}