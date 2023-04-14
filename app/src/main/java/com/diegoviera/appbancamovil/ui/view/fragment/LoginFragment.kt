package com.diegoviera.appbancamovil.ui.view.fragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
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
            //CONSULTA SERVICIO LOGIN
            val user = binding.etDNI.text.toString()
            val password = binding.etPassword.text.toString()
            hideKeyboard()
            userViewModel.iniciarSesion(user, password)

            userViewModel.userModel.observe(viewLifecycleOwner, Observer {
                if (it != null) {
                    if ("true".equals(it.result)) {
                        Toast.makeText(
                            context,
                            "Usuario conectado correctamente",
                            Toast.LENGTH_SHORT
                        ).show()
                        //Enviar parámetro id para consultar productos

                        val bundle = Bundle()
                        bundle.putString("id", it.id.toString())

                        var fr = fragmentManager?.beginTransaction()
                        fr?.replace(R.id.fragment_placeholder, HomeFragment(bundle))?.addToBackStack(null)
                        fr?.commit()

                        //Limpiar campos
                        binding.etDNI.setText("")
                        binding.etPassword.setText("")

                    } else {
                        Toast.makeText(
                            context,
                            "Usuario y/o contraseña incorrectos.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            })
        }
    }

    fun NavController.navigateSafe(
        @IdRes resId: Int,
        args: Bundle? = null,
        navOptions: NavOptions? = null,
        navExtras: Navigator.Extras? = null
    ) {
        val action = currentDestination?.getAction(resId) ?: graph.getAction(resId)
        if (action != null && currentDestination?.id != action.destinationId) {
            navigate(resId, args, navOptions, navExtras)
        }
    }

    fun Fragment.hideKeyboard() {
        view?.let { activity?.hideKeyboard(it) }
    }

    fun Activity.hideKeyboard() {
        hideKeyboard(currentFocus ?: View(this))
    }

    fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}