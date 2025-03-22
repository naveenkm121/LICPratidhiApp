package com.licapps.bmmis.data.model.nua

data class NuaRes(
    var data: List<NuaData> = listOf(),
    var message: String = "",
    var status: Int = 0,
    var token: Any? = null
)