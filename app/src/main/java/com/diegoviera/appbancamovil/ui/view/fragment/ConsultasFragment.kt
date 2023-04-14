package com.diegoviera.appbancamovil.ui.view.fragment

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.diegoviera.appbancamovil.R
import com.diegoviera.appbancamovil.data.model.DetalleProductoModel
import com.diegoviera.appbancamovil.data.model.MovimientoModel
import com.diegoviera.appbancamovil.databinding.FragmentConsultasBinding
import com.diegoviera.appbancamovil.ui.view.dialog.LoadingScreen
import com.diegoviera.appbancamovil.ui.view.fragment.adapter.MovimientoAdapter
import com.diegoviera.appbancamovil.ui.view.fragment.dataclass.DataMovimiento
import com.diegoviera.appbancamovil.ui.view.fragment.dataclass.DetalleMovimiento
import com.diegoviera.appbancamovil.ui.viewmodel.ConsultasViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConsultasFragment(bundle: Bundle) : Fragment() {

    val id = bundle.getString("id")
    val idUser = bundle.getString("idUser")
    val monto = bundle.getString("monto")

    private val consultasViewModel by viewModels<ConsultasViewModel>()

    private var _binding: FragmentConsultasBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentConsultasBinding.inflate(inflater, container, false)
        initView()
        return binding.root
    }

    private fun initView() {
        obtenerMovimientos()
        copiarNroCuenta()
        backScreen()
    }

    private fun copiarNroCuenta() {
        binding.btnCopiar.setOnClickListener {
            val clip = ClipData.newPlainText("text", "Nro. Cuenta: "+binding.tvNroCuentaDetalle.text)
            val clipboard = activity?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            clipboard.setPrimaryClip(clip)
            Toast.makeText(this.context, "Copiado al portapapeles.", Toast.LENGTH_LONG).show()
        }
    }

    private fun obtenerMovimientos() {
        //CONSULTA SERVICIO MOVIMIENTOS
        consultasViewModel.obtenerMovimientos(id!!)

        consultasViewModel.movimientoModel.observe(viewLifecycleOwner, Observer {
            if (it!=null){
                binding.tvTipoCuentaDetalle.text = it.tipoCuenta
                binding.tvNroCuentaDetalle.text = it.nroCuenta.toString()
                val monto = monto
                when (it.tipoCuenta) {
                    "Cuenta Soles" -> binding.tvMontoCuentaDetalle.text = "S/ $monto"
                    "Cuenta Dólares" -> binding.tvMontoCuentaDetalle.text = "US$ $monto"
                }
                initRecyclerView(it)
            }
        })

        consultasViewModel.isLoading.observe(viewLifecycleOwner, Observer {
            if (it){
                LoadingScreen.displayLoading(context,false)
            } else {
                LoadingScreen.hideLoading()
            }
        })
    }

    private fun initRecyclerView(detalleProducto: DetalleProductoModel) {
        binding.rvMovimientos.layoutManager = LinearLayoutManager(this.context)
        binding.rvMovimientos.adapter = MovimientoAdapter(detalleProducto, { onitemSelected(it) })
    }

    private fun backScreen() {
        binding.btnBackProductos.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("idUser", idUser)
            var fr = fragmentManager?.beginTransaction()
            fr?.replace(R.id.flHome, ProductosFragment(bundle))?.addToBackStack(null)
            fr?.commit()
        }
    }

    fun onitemSelected(movimiento: MovimientoModel) {

    }

}