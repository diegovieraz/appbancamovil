package com.diegoviera.appbancamovil.ui.view.fragment.dataclass

data class DataMovimiento(
    val id: Int, //ID de Producto Cuenta
    val nroCuenta: Long, //Número de cuenta
    val tipoCuenta: String, //Tipo de Cuenta (Soles/Dólares)
    val listaMovimiento: List<DetalleMovimiento> //Lista de Movimientos
    //Los datos tipoCuenta y montoCuenta se obtienen en la consulta anterior
)
