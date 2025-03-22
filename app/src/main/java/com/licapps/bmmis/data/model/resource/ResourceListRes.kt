package com.licapps.bmmis.data.model.resource

data class ResourceListRes(
    var data: List<AvailResource> = listOf(),
    var  message:String="",
    var  status:Int=0,

    )