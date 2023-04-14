package com.diegoviera.appbancamovil.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diegoviera.appbancamovil.data.model.UserModel
import com.diegoviera.appbancamovil.domain.GetLoginUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getLoginUseCase: GetLoginUserCase
) : ViewModel() {

    val userModel = MutableLiveData<UserModel?>()
    val isLoading = MutableLiveData<Boolean>()

    fun iniciarSesion() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getLoginUseCase()
            if (result!=null){
                userModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }
}