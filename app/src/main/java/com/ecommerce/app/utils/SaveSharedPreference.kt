package com.ecommerce.app.utils

import android.content.Context
import android.content.SharedPreferences
import com.ecommerce.app.constants.SharedPrefs
import com.ecommerce.app.constants.SharedPrefs.Companion.ACCESS_TOKEN
import com.ecommerce.app.constants.SharedPrefs.Companion.CATEGORY_RES_VAL
import com.ecommerce.app.constants.SharedPrefs.Companion.FCM_TOKEN
import com.ecommerce.app.constants.SharedPrefs.Companion.LOGGED_IN_PREF
import com.ecommerce.app.constants.SharedPrefs.Companion.USER_DETAILS
import com.ecommerce.app.data.category.CategoryRes
import com.ecommerce.app.data.login.UserData
import com.ecommerce.app.data.login.LoginRes


object SaveSharedPreference {
    private fun getUserDetailsPreferences(context: Context?): SharedPreferences? {
        return context?.getSharedPreferences(
            SharedPrefs.USER_DETAILS, Context.MODE_PRIVATE
        )
    }

    private fun getCategoryPreferences(context: Context?): SharedPreferences? {
        return context?.getSharedPreferences(
            SharedPrefs.CATEGORY_RES_PREF, Context.MODE_PRIVATE
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

        var userDetails = loginRes.data
        editor?.putBoolean(LOGGED_IN_PREF, true)
        editor?.putString(USER_DETAILS, GsonHelper.toJson(userDetails))
        editor?.putString(ACCESS_TOKEN, loginRes.token)
        editor?.apply()
    }

    fun logout(context: Context?) {
        val editor: SharedPreferences.Editor? = getUserDetailsPreferences(context)
            ?.edit()
        editor?.putBoolean(LOGGED_IN_PREF, false)
        editor?.putString(USER_DETAILS, "")
        editor?.putString(ACCESS_TOKEN, "")
        editor?.apply()
    }


    /*    fun getLoggedStatus(context: Context?): Boolean? {
           if(getUserDetailsPreferences(context)?.getBoolean(LOGGED_IN_PREF, false)==false||getUserDetails(context)?.token.isNullOrEmpty())
               return false
            else
                return true
        }*/
    fun getUserDetails(context: Context?): UserData? {
        val userDataJson: String =
            getUserDetailsPreferences(context)?.getString(USER_DETAILS, "").toString()
        return GsonHelper.fromJson(userDataJson, UserData::class.java)
    }

    fun getTokenValue(context: Context?): String {
        val token = getUserDetailsPreferences(context)?.getString(ACCESS_TOKEN, "").toString()
        return token
    }

    fun setCategoryValue(context: Context?, categoryRes: CategoryRes) {
        val editor: SharedPreferences.Editor? = getCategoryPreferences(context)?.edit()
        editor?.putString(CATEGORY_RES_VAL, GsonHelper.toJson(categoryRes))
        editor?.apply()
    }

    fun getCategoryResValue(context: Context?): CategoryRes? {
        val categoryResJSON = getCategoryPreferences(context)?.getString(CATEGORY_RES_VAL, "").toString()
        return GsonHelper.fromJson(categoryResJSON, CategoryRes::class.java)
    }

    fun getFCMToken(context: Context?): String {
        val token = getUserDetailsPreferences(context)?.getString(SharedPrefs.FCM_TOKEN, "").toString()
        return token
    }
    fun setFCMToken(context: Context?, fcmToken: String) {
        val editor: SharedPreferences.Editor? = getCategoryPreferences(context)?.edit()
        editor?.putString(FCM_TOKEN, fcmToken)
        editor?.apply()
    }


}