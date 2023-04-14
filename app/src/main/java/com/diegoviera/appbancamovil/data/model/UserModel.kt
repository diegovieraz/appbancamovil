package com.diegoviera.appbancamovil.data.model

import com.google.gson.annotations.SerializedName

data class UserModel (
    @SerializedName("result")
    val result:String,
    @SerializedName("id")
    val id:Int
)