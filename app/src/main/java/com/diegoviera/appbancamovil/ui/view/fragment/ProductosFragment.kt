package com.diegoviera.appbancamovil.ui.view.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.diegoviera.appbancamovil.R
import com.diegoviera.appbancamovil.data.model.ProductoModel
import com.diegoviera.appbancamovil.databinding.FragmentProductosBinding
import com.diegoviera.appbancamovil.ui.view.fragment.adapter.ProductoAdapter
import com.diegoviera.appbancamovil.ui.view.fragment.dataclass.DataProducto
import com.diegoviera.appbancamovil.ui.viewmodel.ProductosViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductosFragment(bundle: Bundle) : Fragment() {

    val idUser = bundle.getString("idUser")

    private val productosViewModel by viewModels<ProductosViewModel>()

    private var _binding: FragmentProductosBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentProductosBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configurarSwipe()
        obtenerProductos()
        backScreen()
    }

    private fun configurarSwipe() {

        binding.srProductos.setColorSchemeResources(R.color.bg_teal, R.color.teal_700)

        binding.srProductos.setOnRefreshListener {
            Handler(Looper.getMainLooper()).postDelayed({
                binding.srProductos.isRefreshing = false
                refrescarProductos()
            },1000)
        }
    }

    private fun obtenerProductos() {
        //CONSULTA SERVICIO PRODUCTOS
        productosViewModel.obtenerProductos(idUser!!)

        productosViewModel.productoModel.observe(viewLifecycleOwner, Observer {
            if (!it.isNullOrEmpty()) {
                initRecyclerView(it)
            }
        })
    }

    private fun refrescarProductos() {
        //CONSULTA SERVICIO ACTUALIZAR PRODUCTOS
        productosViewModel.actualizarProductos(idUser!!)

        productosViewModel.productoModel.observe(viewLifecycleOwner, Observer {
            if (!it.isNullOrEmpty()) {
                initRecyclerView(it)
            }
        })
    }

    private fun initRecyclerView(listaProds: List<ProductoModel>) {
        binding.rvProductos.layoutManager = LinearLayoutManager(this.context)
        binding.rvProductos.adapter = ProductoAdapter(listaProds, { onitemSelected(it) })
    }

    fun onitemSelected(producto: ProductoModel) {
        //Enviar parámetro producto para consultar productos
        val bundle = Bundle()
        bundle.putString("idUser", idUser)
        bundle.putString("id", producto.idProd.toString())
        bundle.putString("monto", producto.montoCuenta.toString())

        var fr = fragmentManager?.beginTransaction()
        fr?.replace(R.id.flHome, ConsultasFragment(bundle))?.addToBackStack(null)
        fr?.commit()

    }

    private fun backScreen() {
        binding.btnBackLogin.setOnClickListener {
            var fr = fragmentManager?.beginTransaction()
            fr?.replace(R.id.fragment_placeholder, LoginFragment())?.addToBackStack(null)
            fr?.commit()
        }
    }


}