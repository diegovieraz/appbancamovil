package com.diegoviera.appbancamovil.data.model

import com.google.gson.annotations.SerializedName

data class MovimientoModel(
    @SerializedName("idTransf")
    val idTransf: Int, //ID de Transferencia
    @SerializedName("descTransf")
    val descTransf: String, //Descripción de Transferencia
    @SerializedName("fechaTransf")
    val fechaTransf: String, //Fecha de Transferencia
    @SerializedName("tipoTransf")
    val tipoTransf: String, //Tipo de Transferencia (Positiva/Negativa)
    @SerializedName("montoTransf")
    val montoTransf: Float, //Monto de Transferencia
)