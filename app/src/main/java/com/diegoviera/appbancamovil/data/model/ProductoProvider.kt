package com.diegoviera.appbancamovil.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductoProvider @Inject constructor() {

    lateinit var response:List<ProductoModel>

}