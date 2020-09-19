package com.androidvoyage.matrimonk.comclass

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.androidvoyage.matrimonk.R


class ComUtils {

    //To check if device has internet connectivity
    fun isOnline(activity: Activity): Boolean {
        val connMgr = activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connMgr.activeNetworkInfo
        if(networkInfo != null && networkInfo.isConnectedOrConnecting){
            return true
        }
        return false
    }


    //Show custom toast as per our app
    fun showToast(activity: Activity, msg: String) {
        val inflater = activity.layoutInflater
        val view: View = inflater.inflate(
            R.layout.custom_toast,
            activity.findViewById(R.id.custom_toast_container)
        )
        val tvToast: TextView = view.findViewById(R.id.tv_toast)
        tvToast.isSelected = msg != activity.getString(R.string.str_new_matches)
        tvToast.setText(msg)
        val toast = Toast(activity)
        toast.duration = Toast.LENGTH_SHORT
        toast.setView(view)
        toast.setGravity(Gravity.TOP,0,400)
        if(msg.isNotEmpty()){
            toast.show()
        }
    }

}