package com.licapps.bmmis.data.model.activisation

data class ActivisationListRes(
    var message: String = "",
    var status: Int = 0,
    var data: List<ActivisationItem> = listOf()
)