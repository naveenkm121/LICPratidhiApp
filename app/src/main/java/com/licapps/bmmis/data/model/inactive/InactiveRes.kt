package com.licapps.bmmis.data.model.inactive

data class InactiveRes(
    var message: String = "",
    var status: Int = 0,
    var data: List<Inactive> = listOf()
)