package com.licapps.bmmis.utils

import androidx.room.TypeConverter

class Converters {
    companion object {
        @TypeConverter
        @JvmStatic
        fun toListOfInts(flatStringList: String): List<Int> {
            return flatStringList.split(",").map { if (it.trim().isNotEmpty()) it.toInt() else 0 }
        }

        @JvmStatic
        @TypeConverter
        fun fromListOfInts(listOfString: List<Int>?): String {
            if (listOfString != null)
                return listOfString.joinToString(",")
            else
                return ""
        }

        @TypeConverter
        @JvmStatic
        fun toListOfStrings(flatStringList: String): List<String> {
            return flatStringList.split(",").map { if (it.trim().isNotEmpty()) it else "" }
        }

        @JvmStatic
        @TypeConverter
        fun fromListOfStrings(listOfString: List<String>): String {
            return listOfString.joinToString(",")
        }


    }
}
