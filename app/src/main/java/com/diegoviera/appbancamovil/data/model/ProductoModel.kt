package com.diegoviera.appbancamovil.data.model

import com.google.gson.annotations.SerializedName

data class ProductoModel(
    @SerializedName("idProd")
    val idProd: Int, //ID de Producto Cuenta
    @SerializedName("tipoCuenta")
    val tipoCuenta: String, //Tipo de Cuenta (Soles/Dólares)
    @SerializedName("montoCuenta")
    val montoCuenta: Float //Monto Saldo de la cuenta
)