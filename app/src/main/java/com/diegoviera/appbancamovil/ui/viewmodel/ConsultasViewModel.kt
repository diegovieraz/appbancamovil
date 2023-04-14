package com.diegoviera.appbancamovil.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diegoviera.appbancamovil.data.model.DetalleProductoModel
import com.diegoviera.appbancamovil.domain.GetMovementsUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConsultasViewModel @Inject constructor(
    private val getMovementsUserCase: GetMovementsUserCase
) : ViewModel() {

    val movimientoModel = MutableLiveData<DetalleProductoModel?>()
    val isLoading = MutableLiveData<Boolean>()

    fun obtenerMovimientos(id: String) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getMovementsUserCase(id)
            if (result!=null){
                movimientoModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }

}