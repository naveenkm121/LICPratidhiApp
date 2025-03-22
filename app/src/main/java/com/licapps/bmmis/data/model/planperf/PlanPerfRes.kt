package com.licapps.bmmis.data.model.planperf

data class PlanPerfRes(
    var message: String = "",
    var status: Int = 0,
    var data: List<PlanPerfItem> = listOf()
)