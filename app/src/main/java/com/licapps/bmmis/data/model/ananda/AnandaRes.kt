package com.licapps.bmmis.data.model.ananda

data class AnandaRes(
    var message: String = "",
    var status: Int = 0,
    var data: List<AnandaItem> = listOf()
)