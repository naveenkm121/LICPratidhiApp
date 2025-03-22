package com.licapps.bmmis.data.model.nbperformance


data class NBPerformanceRes(

    var data: List<NBPerformance> = listOf(),
    var  message:String="",
    var  status:Int=0,

)