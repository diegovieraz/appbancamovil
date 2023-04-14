package com.diegoviera.appbancamovil.ui.view.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.widget.TextView
import com.diegoviera.appbancamovil.R

object LoadingScreen {
    var dialog: Dialog? = null
    fun displayLoading(context: Context?, cancelable: Boolean) {
        dialog = Dialog(context!!)
        dialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog!!.setContentView(R.layout.loading_item)
        dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.parseColor("#70018786")))
        dialog!!.setCancelable(cancelable)
        try {
            dialog!!.show()
        } catch (e: Exception) {
        }
    }

    fun hideLoading() {
        try {
            if (dialog != null) {
                dialog!!.dismiss()
            }
        } catch (e: Exception) {
        }
    }
}