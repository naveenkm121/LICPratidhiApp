package com.licapps.bmmis.data.model.channelwise

data class ChannelwiseNBRes(
    var message: String = "",
    var status: Int = 0,
    var data: List<ChannelwiseNB> = listOf()
)