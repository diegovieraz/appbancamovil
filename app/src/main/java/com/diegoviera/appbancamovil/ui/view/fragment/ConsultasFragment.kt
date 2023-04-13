package com.diegoviera.appbancamovil.ui.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.diegoviera.appbancamovil.databinding.FragmentConsultasBinding
import com.diegoviera.appbancamovil.ui.view.fragment.adapter.MovimientoAdapter
import com.diegoviera.appbancamovil.ui.view.fragment.dataclass.DataMovimiento
import com.diegoviera.appbancamovil.ui.view.fragment.dataclass.DetalleMovimiento

class ConsultasFragment() : Fragment() {

    private var _binding: FragmentConsultasBinding? = null
    private val binding get() = _binding!!

    val movimientos = listOf<DetalleMovimiento>(
        DetalleMovimiento(1, "Transferencia", "13 Abr 2023", "Positivo", 6.10f),
        DetalleMovimiento(2, "Plin", "12 Abr 2023", "Negativo", 10.00f),
        DetalleMovimiento(3, "Pago Estudios", "11 Abr 2023", "Positivo", 54.70f),
    )
    val detalle = DataMovimiento(1, 999988887777, "Cuenta Soles", movimientos)

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
        binding.tvTipoCuentaDetalle.text = detalle.tipoCuenta
        binding.tvNroCuentaDetalle.text = detalle.nroCuenta.toString()
        val monto = "1000.80"
        when (detalle.tipoCuenta) {
            "Cuenta Soles" -> binding.tvMontoCuentaDetalle.text = "S/ $monto"
            "Cuenta Dólares" -> binding.tvMontoCuentaDetalle.text = "US$ $monto"
        }
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.rvMovimientos.layoutManager = LinearLayoutManager(this.context)
        binding.rvMovimientos.adapter = MovimientoAdapter(detalle, { onitemSelected(it) })
    }

    fun onitemSelected(movimiento: DetalleMovimiento) {

    }

}