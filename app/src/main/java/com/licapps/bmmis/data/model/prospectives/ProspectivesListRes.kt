package com.licapps.bmmis.data.model.prospectives


data class ProspectivesListRes(

    var data: List<Prospective> = listOf(),
    var  message:String="",
    var  status:Int=0,

)