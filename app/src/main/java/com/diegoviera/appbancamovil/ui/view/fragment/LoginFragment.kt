package com.diegoviera.appbancamovil.ui.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.diegoviera.appbancamovil.R
import com.diegoviera.appbancamovil.databinding.FragmentLoginBinding
import com.diegoviera.appbancamovil.ui.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val userViewModel by viewModels<UserViewModel>()

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        initView()
        return binding.root
    }

    private fun initView() {
        binding.btnIngresar.setOnClickListener {
            //CONSULTA LOGIN
            userViewModel.iniciarSesion()

            userViewModel.userModel.observe(viewLifecycleOwner, Observer {
                if (it != null) {
                    if ("true".equals(it.result)){
                        Toast.makeText(context, "Usuario conectado correctamente", Toast.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                    } else {
                        Toast.makeText(context, "Usuario y/o contraseña incorrectos.", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }
    }
}