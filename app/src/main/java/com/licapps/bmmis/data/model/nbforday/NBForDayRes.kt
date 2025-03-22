package com.licapps.bmmis.data.model.nbforday

data class NBForDayRes(
    var message: String = "",
    var status: Int = 0,
    var data: List<NBForDayItem> = listOf()
)