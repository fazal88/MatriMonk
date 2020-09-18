package com.androidvoyage.matrimonk.comclass

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.androidvoyage.matrimonk.R


class ComUtils {
    fun isOnline(activity: Activity): Boolean {
        val connMgr = activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connMgr.activeNetworkInfo
        if(networkInfo != null && networkInfo.isConnectedOrConnecting){
            return true
        }
        noInternetToast( activity,"No Internet!")
        return false
    }


    fun noInternetToast(activity: Activity, msg: String) {
        val inflater = activity.layoutInflater
        val view: View = inflater.inflate(
            R.layout.custom_toast,
            activity.findViewById(R.id.custom_toast_container)
        )
        val tvToast: TextView = view.findViewById(R.id.tv_toast)
        val ivToast: ImageView = view.findViewById(R.id.iv_toast)
        tvToast.isSelected = true
        ivToast.isSelected = true
        tvToast.setText(msg)
        val toast = Toast(activity)
        toast.duration = Toast.LENGTH_LONG
        toast.setView(view)
        toast.setGravity(Gravity.TOP,0,400)
        toast.show()
    }


    fun showToast(activity: Activity, msg: String) {
        val inflater = activity.layoutInflater
        val view: View = inflater.inflate(
            R.layout.custom_toast,
            activity.findViewById(R.id.custom_toast_container)
        )
        val tvToast: TextView = view.findViewById(R.id.tv_toast)
        val ivToast: ImageView = view.findViewById(R.id.iv_toast)
        tvToast.isSelected = false
        ivToast.isSelected = false
        tvToast.setText(msg)
        val toast = Toast(activity)
        toast.duration = Toast.LENGTH_LONG
        toast.setView(view)
        toast.setGravity(Gravity.TOP,0,400)
        toast.show()
    }

}