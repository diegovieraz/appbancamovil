package com.diegoviera.appbancamovil.ui.view.fragment.adapter

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.diegoviera.appbancamovil.R
import com.diegoviera.appbancamovil.data.model.ProductoModel
import com.diegoviera.appbancamovil.databinding.AdapterProductoBinding
import com.diegoviera.appbancamovil.ui.view.fragment.dataclass.DataProducto

class ProductoViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    val binding = AdapterProductoBinding.bind(view)

    fun render(producto: ProductoModel, onClickListener: (ProductoModel) -> Unit) {
        //SETEAR INFORMACIÓN DE CUENTAS
        binding.tvTipoCuenta.text = producto.tipoCuenta
        val monto = producto.montoCuenta.toString()
        when (producto.tipoCuenta) {
            "Cuenta Soles" -> binding.tvMontoCuenta.text = "S/ $monto"
            "Cuenta Dólares" -> binding.tvMontoCuenta.text = "US$ $monto"
        }

        //GENERAR ACCIONES PARA IR A DETALLE DE CUENTAS
        itemView.setOnClickListener { onClickListener(producto) }
    }


}