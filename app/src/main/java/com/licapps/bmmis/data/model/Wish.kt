package com.licapps.bmmis.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wishes")
data class Wish(
    @PrimaryKey
    val id: Int,
    val imageurl: String,
    val category:String
)