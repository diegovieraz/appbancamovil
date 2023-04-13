package com.diegoviera.appbancamovil.ui.view.fragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diegoviera.appbancamovil.R
import com.diegoviera.appbancamovil.ui.view.fragment.dataclass.DataMovimiento
import com.diegoviera.appbancamovil.ui.view.fragment.dataclass.DetalleMovimiento

class MovimientoAdapter(private val detalle: DataMovimiento, private val onClickListener:(DetalleMovimiento) -> Unit) : RecyclerView.Adapter<MovimientoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovimientoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MovimientoViewHolder(layoutInflater.inflate(R.layout.adapter_movimiento, parent, false))
    }

    override fun onBindViewHolder(holder: MovimientoViewHolder, position: Int) {
        val movimientos = detalle.listaMovimiento
        val item = movimientos[position]
        holder.render(detalle, item, onClickListener)
    }

    override fun getItemCount(): Int = detalle.listaMovimiento.size
}