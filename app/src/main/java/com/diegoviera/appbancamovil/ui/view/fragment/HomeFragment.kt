package com.diegoviera.appbancamovil.ui.view.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.diegoviera.appbancamovil.R
import com.diegoviera.appbancamovil.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        setHomeFragment()

        return binding.root
    }

    private fun setHomeFragment() {
        var fr = fragmentManager?.beginTransaction()
        fr?.replace(R.id.flHome, ProductosFragment())
        fr?.commit()
    }

    // DE EXISTIR UN REQUERIMIENTO PARA HACER USO DEL NAVIGATION BOTTOM BAR, SE HARÍA UNA IMPLEMENTACIÓN PARA CAMBIAR LAS
    // VISTAS DE LOS FRAGMENTOS A OTRO APARTADO. DE MOMENTO SOLO SE USA LA PRIMERA VISTA (PRODUCTOS)
}