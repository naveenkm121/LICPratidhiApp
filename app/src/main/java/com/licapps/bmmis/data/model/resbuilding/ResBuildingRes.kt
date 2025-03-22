package com.licapps.bmmis.data.model.resbuilding

data class ResBuildingRes(
    var message: String = "",
    var status: Int = 0,
    var data: List<ResBuildingItem> = listOf()
)