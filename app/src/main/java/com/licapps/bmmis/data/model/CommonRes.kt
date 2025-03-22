package com.licapps.bmmis.data.model

import java.io.Serializable

data class CommonRes(
    var message: String = "",
    var status: Int = 0,
    var data: Any=Any()
):Serializable

