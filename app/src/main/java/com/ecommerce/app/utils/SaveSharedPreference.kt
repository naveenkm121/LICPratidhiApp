package com.ecommerce.app.utils

import android.content.Context
import android.content.SharedPreferences
import android.service.autofill.UserData
import com.ecommerce.app.constants.SharedPrefs
import com.ecommerce.app.constants.SharedPrefs.Companion.ACCESS_TOKEN
import com.ecommerce.app.constants.SharedPrefs.Companion.LOGGED_IN_PREF
import com.ecommerce.app.constants.SharedPrefs.Companion.USER_DETAILS
import com.ecommerce.app.data.login.LoginData
import com.ecommerce.app.data.login.LoginRes
import com.ecommerce.app.data.product.ProductItem


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
        editor?.putString(USER_DETAILS, GsonHelper.toJson(userDetails))
        editor?.putString(ACCESS_TOKEN, loginRes.token)
        editor?.apply()
    }
    fun logout(context: Context?) {
        val editor: SharedPreferences.Editor? = getUserDetailsPreferences(context)
            ?.edit()
        editor?.putBoolean(LOGGED_IN_PREF, false )
        editor?.putString(USER_DETAILS, "" )
        editor?.putString(ACCESS_TOKEN, "")
        editor?.apply()
    }


/*    fun getLoggedStatus(context: Context?): Boolean? {
       if(getUserDetailsPreferences(context)?.getBoolean(LOGGED_IN_PREF, false)==false||getUserDetails(context)?.token.isNullOrEmpty())
           return false
        else
            return true
    }*/
    fun getUserDetails(context: Context?): LoginData? {
        val userDataJson:String = getUserDetailsPreferences(context)?.getString(USER_DETAILS, "").toString()
        return GsonHelper.fromJson(userDataJson, LoginData::class.java)
    }

    fun getTokenValue(context: Context?): String {
        val token = getUserDetailsPreferences(context)?.getString(ACCESS_TOKEN, "").toString()
        return token
    }

}