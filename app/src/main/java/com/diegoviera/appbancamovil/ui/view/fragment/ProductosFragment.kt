package com.diegoviera.appbancamovil.ui.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.diegoviera.appbancamovil.R
import com.diegoviera.appbancamovil.databinding.FragmentProductosBinding
import com.diegoviera.appbancamovil.ui.view.fragment.adapter.ProductoAdapter
import com.diegoviera.appbancamovil.ui.view.fragment.dataclass.DataProducto


class ProductosFragment : Fragment() {

    private var _binding: FragmentProductosBinding? = null
    private val binding get() = _binding!!

    val productos = listOf<DataProducto>(
        DataProducto(1, "Cuenta Soles", 1000.85f),
        DataProducto(2, "Cuenta Dólares", 870.00f),
        DataProducto(3, "Cuenta Soles", 2300.40f)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentProductosBinding.inflate(inflater, container, false)
        initView()
        return binding.root
    }

    private fun initView() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.rvProductos.layoutManager = LinearLayoutManager(this.context)
        binding.rvProductos.adapter = ProductoAdapter(productos, { onitemSelected(it) })
    }

    fun onitemSelected(producto: DataProducto) {
        var fr = fragmentManager?.beginTransaction()
        fr?.replace(R.id.flHome, ConsultasFragment())
        fr?.commit()

    }

}