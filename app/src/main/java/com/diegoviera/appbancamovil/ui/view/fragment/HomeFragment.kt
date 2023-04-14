package com.diegoviera.appbancamovil.ui.view.fragment


import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.diegoviera.appbancamovil.R
import com.diegoviera.appbancamovil.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment(bundle: Bundle) : Fragment() {

    val id = bundle.getString("id")

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    //SE GENERA UN TIMER PARA DEVOLVER AL LOGIN FRAGMENT. Duración: 2 minutos (120000 milisegundos)
    val timer = object : CountDownTimer(120000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
        }
        override fun onFinish() {
            Toast.makeText(context, "Tiempo agotado. Vuelva a iniciar sesión.", Toast.LENGTH_SHORT).show()
            binding.bnvHome.visibility = View.GONE
            var fr = fragmentManager?.beginTransaction()
            fr?.replace(R.id.flHome, LoginFragment())?.addToBackStack(null)
            fr?.commit()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.bnvHome.visibility = View.VISIBLE
        timer.start()
        obtenerProductos()
        return binding.root
    }

    private fun setHomeFragment(id: String?) {
        val bundle = Bundle()
        bundle.putString("idUser", id)
        var fr = fragmentManager?.beginTransaction()
        fr?.replace(R.id.flHome, ProductosFragment(bundle))?.addToBackStack(null)
        fr?.commit()
    }

    private fun obtenerProductos() {
        setHomeFragment(id)
    }



    // DE EXISTIR UN REQUERIMIENTO PARA HACER USO DEL NAVIGATION BOTTOM BAR, SE HARÍA UNA IMPLEMENTACIÓN PARA CAMBIAR LAS
    // VISTAS DE LOS FRAGMENTOS A OTRO APARTADO. DE MOMENTO SOLO SE USA LA PRIMERA VISTA (PRODUCTOS)
}