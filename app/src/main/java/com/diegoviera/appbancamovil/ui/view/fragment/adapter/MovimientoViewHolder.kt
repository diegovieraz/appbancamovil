package com.diegoviera.appbancamovil.ui.view.fragment.adapter

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.diegoviera.appbancamovil.R
import com.diegoviera.appbancamovil.data.model.DetalleProductoModel
import com.diegoviera.appbancamovil.data.model.MovimientoModel
import com.diegoviera.appbancamovil.databinding.AdapterMovimientoBinding
import com.diegoviera.appbancamovil.ui.view.fragment.dataclass.DataMovimiento
import com.diegoviera.appbancamovil.ui.view.fragment.dataclass.DetalleMovimiento

class MovimientoViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    val binding = AdapterMovimientoBinding.bind(view)

    fun render(detalle: DetalleProductoModel, movimiento: MovimientoModel, onClickListener: (MovimientoModel) -> Unit) {
        //SETEAR INFORMACIÓN DE MOVIMIENTOS
        binding.tvDescTransfer.text = movimiento.descTransf
        binding.tvFechaTransfer.text = movimiento.fechaTransf
        var tipoTransfer = ""
        when (detalle.tipoCuenta) {
            "Cuenta Soles" -> tipoTransfer = "S/"
            "Cuenta Dólares" -> tipoTransfer = "US$"
        }

        val monto = String.format("%.2f",movimiento.montoTransf)
        when (movimiento.tipoTransf) {
            "Positivo" -> {
                binding.tvMontoTransfer.setTextColor(Color.parseColor("#23A84E"))
                binding.tvMontoTransfer.text = "$tipoTransfer +$monto"
            }
            "Negativo" -> {
                binding.tvMontoTransfer.setTextColor(Color.parseColor("#E91E63"))
                binding.tvMontoTransfer.text = "$tipoTransfer -$monto"
            }
        }
    }

}