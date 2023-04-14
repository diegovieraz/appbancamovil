package com.diegoviera.appbancamovil.ui.view.fragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diegoviera.appbancamovil.R
import com.diegoviera.appbancamovil.data.model.ProductoModel
import com.diegoviera.appbancamovil.ui.view.fragment.dataclass.DataProducto

class ProductoAdapter(private val productos: List<ProductoModel>, private val onClickListener:(ProductoModel) -> Unit) : RecyclerView.Adapter<ProductoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProductoViewHolder(layoutInflater.inflate(R.layout.adapter_producto, parent, false))
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val item = productos[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = productos.size
}