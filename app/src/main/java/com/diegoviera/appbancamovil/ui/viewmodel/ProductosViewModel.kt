package com.diegoviera.appbancamovil.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diegoviera.appbancamovil.data.model.ProductoModel
import com.diegoviera.appbancamovil.domain.GetProductsUserCase
import com.diegoviera.appbancamovil.domain.RefreshProductsUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductosViewModel @Inject constructor(
    private val getProductsUserCase: GetProductsUserCase,
    private val refreshProductsUserCase: RefreshProductsUserCase
) : ViewModel() {

    val productoModel = MutableLiveData<List<ProductoModel>?>()
    val isLoading = MutableLiveData<Boolean>()

    fun obtenerProductos(id: String) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getProductsUserCase(id)
            if (result != null) {
                productoModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }

    fun actualizarProductos(id: String) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = refreshProductsUserCase(id)
            if (result != null) {
                productoModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }

}