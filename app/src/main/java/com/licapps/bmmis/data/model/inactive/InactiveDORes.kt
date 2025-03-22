package com.licapps.bmmis.data.model.inactive

data class InactiveDORes(
    var message: String = "",
    var status: Int = 0,
    var data: List<InactiveDOCLIA> = listOf()
)