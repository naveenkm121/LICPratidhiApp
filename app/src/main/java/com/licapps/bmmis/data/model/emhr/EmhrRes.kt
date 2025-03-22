package com.licapps.bmmis.data.model.emhr

import com.licapps.bmmis.data.model.nua.NuaData

data class EmhrRes(
    var data: List<EmhrData> = listOf(),
    var message: String = "",
    var status: Int = 0,
    var token: Any? = null
)
