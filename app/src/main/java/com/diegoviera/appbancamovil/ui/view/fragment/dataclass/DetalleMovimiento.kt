package com.diegoviera.appbancamovil.ui.view.fragment.dataclass

data class DetalleMovimiento(
    val idTransf: Int, //ID de la transferencia
    val descTransf: String, //Descripción de la transferencia
    val fechaTransf: String, //Fecha de la transferencia
    val tipoTransf: String, //Tipo de la transferencia (Positiva o negativa)
    val montoTransf: Float //Monto de la transferencia
)
