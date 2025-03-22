package com.licapps.bmmis.data.model.boc

import com.licapps.bmmis.data.model.topperformers.Performer


data class BOCListRes(

    var data: List<BOCItem> = listOf(),
    var  message:String="",
    var  status:Int=0,

    )