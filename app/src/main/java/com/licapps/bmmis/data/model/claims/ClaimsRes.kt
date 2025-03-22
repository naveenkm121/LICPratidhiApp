package com.licapps.bmmis.data.model.claims

data class ClaimsRes(
    var message: String = "",
    var status: Int = 0,
    var data: List<ClaimsItem> = listOf()
)