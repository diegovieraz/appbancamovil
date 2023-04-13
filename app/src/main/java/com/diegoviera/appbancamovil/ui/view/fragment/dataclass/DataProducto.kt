package com.diegoviera.appbancamovil.ui.view.fragment.dataclass

data class DataProducto(
    val id: Int, //ID de Producto Cuenta
    val tipoCuenta: String, //Tipo de Cuenta (Soles/Dólares)
    val montoCuenta: Float //Monto Saldo de la cuenta
)
