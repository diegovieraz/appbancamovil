package com.diegoviera.appbancamovil.data.model

import com.google.gson.annotations.SerializedName

data class DetalleProductoModel(
    @SerializedName("id")
    val id: Int, //ID de Producto Cuenta
    @SerializedName("nroCuenta")
    val nroCuenta: Long, //Número de Cuenta
    @SerializedName("tipoCuenta")
    val tipoCuenta: String, //Tipo de Cuenta (Soles/Dólares)
    @SerializedName("movimientos")
    val movimientos: List<MovimientoModel>? //Lista de Movimientos
)
