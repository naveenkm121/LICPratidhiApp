package com.licapps.bmmis.data.model.mab

data class MABListRes(
    var message: String = "",
    var status: Int = 0,
    var data: List<MABItem> = listOf()
)