package com.licapps.bmmis.utils

import android.content.Context
import android.content.SharedPreferences
import com.licapps.bmmis.constants.SharedPrefs
import com.licapps.bmmis.constants.SharedPrefs.Companion.ACCESS_TOKEN
import com.licapps.bmmis.constants.SharedPrefs.Companion.BRANCH
import com.licapps.bmmis.constants.SharedPrefs.Companion.DESG
import com.licapps.bmmis.constants.SharedPrefs.Companion.DEVICE_ID
import com.licapps.bmmis.constants.SharedPrefs.Companion.EMAIL_ID
import com.licapps.bmmis.constants.SharedPrefs.Companion.LOGGED_IN_PREF
import com.licapps.bmmis.constants.SharedPrefs.Companion.NAME
import com.licapps.bmmis.constants.SharedPrefs.Companion.PIN
import com.licapps.bmmis.constants.SharedPrefs.Companion.PIN_STATUS
import com.licapps.bmmis.constants.SharedPrefs.Companion.SR_NO
import com.licapps.bmmis.data.model.login.LoginData
import com.licapps.bmmis.data.model.login.LoginRes

object SaveSharedPreference {
    private fun getUserDetailsPreferences(context: Context?): SharedPreferences? {
        return context?.getSharedPreferences(
            SharedPrefs.USER_DETAILS, Context.MODE_PRIVATE
        )
    }

    /**
     * Set the Login Status
     * @param context
     * @param loggedIn
     */
    fun login(context: Context?, loginRes: LoginRes) {
        val editor: SharedPreferences.Editor? = getUserDetailsPreferences(context)
            ?.edit()

       var  userDetails=loginRes.data
        editor?.putBoolean(LOGGED_IN_PREF, true )

        editor?.putString(EMAIL_ID, userDetails.email)
        editor?.putString(SR_NO, userDetails.sr_number)
        editor?.putString(BRANCH, userDetails.branch.trim())
        editor?.putString(NAME, userDetails.name)
        editor?.putString(DESG, userDetails.designation)
        editor?.putString(ACCESS_TOKEN, loginRes.token)
        editor?.apply()
    }
    fun logout(context: Context?) {
        val editor: SharedPreferences.Editor? = getUserDetailsPreferences(context)
            ?.edit()
        editor?.putBoolean(LOGGED_IN_PREF, false )

        editor?.putString(EMAIL_ID, "" )
        editor?.putString(SR_NO, "")
        editor?.putString(BRANCH, "")
        editor?.putString(NAME, "")
        editor?.putString(DESG, "")
        editor?.putString(ACCESS_TOKEN, "")
        editor?.putString(PIN, "")
        editor?.apply()
    }

    fun setPin(context: Context?,pin:String): Boolean? {
        return getUserDetailsPreferences(context)?.edit()?.putString(PIN, pin )?.commit()
    }
    fun getPin(context: Context?): String? {
        return getUserDetailsPreferences(context)?.getString(PIN, "" )
    }
    fun getDeviceId(context: Context?): String? {
        return getUserDetailsPreferences(context)?.getString(DEVICE_ID, "")
    }

    fun setDeviceId(context: Context?,deviceId:String):Boolean? {
        return getUserDetailsPreferences(context)?.edit()?.putString(DEVICE_ID, deviceId )?.commit()
    }
    /**
     * Get the Login Status
     * @param context
     * @return boolean: login status
     */
    fun getLoggedStatus(context: Context?): Boolean? {
       if(getUserDetailsPreferences(context)?.getBoolean(LOGGED_IN_PREF, false)==false||getUserDetails(context)?.token.isNullOrEmpty())
           return false
        else
            return true
    }
    fun getUserDetails(context: Context?): LoginData? {
        var loginData=LoginData()
        loginData.email= getUserDetailsPreferences(context)?.getString(EMAIL_ID, "").toString()
        loginData.name= getUserDetailsPreferences(context)?.getString(NAME, "").toString()
        loginData.designation= getUserDetailsPreferences(context)?.getString(DESG, "").toString()
        loginData.branch= getUserDetailsPreferences(context)?.getString(BRANCH, "").toString()
        loginData.sr_number= getUserDetailsPreferences(context)?.getString(SR_NO, "").toString()
        loginData.token= getUserDetailsPreferences(context)?.getString(ACCESS_TOKEN, "").toString()
        return loginData
    }

}