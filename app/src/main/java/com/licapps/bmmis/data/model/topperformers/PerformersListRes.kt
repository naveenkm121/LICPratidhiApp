package com.licapps.bmmis.data.model.topperformers


data class PerformersListRes(

    var data: List<Performer> = listOf(),
    var  message:String="",
    var  status:Int=0,

)