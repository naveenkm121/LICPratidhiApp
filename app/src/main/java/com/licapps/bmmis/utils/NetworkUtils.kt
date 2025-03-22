package com.licapps.bmmis.utils

import android.content.Context
import android.content.Context.WIFI_SERVICE
import android.net.wifi.WifiManager
import android.text.format.Formatter

class NetworkUtils {


    companion object {
        fun getIpAddress(context: Context): String {

            var wifiManager =
                context.applicationContext.getSystemService(WIFI_SERVICE) as WifiManager
            return Formatter.formatIpAddress(wifiManager.connectionInfo.ipAddress)
        }


    }

}