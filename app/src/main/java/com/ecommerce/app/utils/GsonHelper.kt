package com.ecommerce.app.utils

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class GsonHelper {

    companion object {
        private var hasGson: Boolean? = null
        private var gson: Any? = null

        fun hasGson(): Boolean {
            if (hasGson == null) {
                hasGson = try {
                    Class.forName("com.google.gson.Gson")
                    true
                } catch (e: Exception) {
                    false
                }
            }
            return hasGson!!
        }

        fun get(): Gson? {
            if (gson == null) {
                gson = Gson()
                val builder = GsonBuilder()
                gson = builder.serializeNulls().create()
            }
            return gson as Gson?
        }

        fun toJson(obj: Any?): String? {
            return try {
                if (obj == null) null else get()!!.toJson(obj)
            } catch (e: Exception) {
                println("GsonHelper :: Cannot convert object to JSON")
                e.printStackTrace()
                null
            }
        }

        fun <T> fromJson(str: String?, clazz: Class<T>?): T? {
            return fromJson(str, clazz as Type?)
        }

        fun <T> fromJson(str: String?, type: Type?): T? {
            return try {
                if (str == null) null else get()!!.fromJson<Any>(str, type) as T
            } catch (e: Exception) {
                println("GsonHelper :: Cannot convert object to JSON")
                e.printStackTrace()
                null
            }
        }

        fun <T> getList(json: String?, clazz: Class<T>?): List<T>? {
            val typeOfT = TypeToken.getParameterized(MutableList::class.java, clazz).type
            return Gson().fromJson(json, typeOfT)
        }
    }
}