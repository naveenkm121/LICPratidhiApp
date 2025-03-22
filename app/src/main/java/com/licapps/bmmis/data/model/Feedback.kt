package com.licapps.bmmis.data.model

import java.io.Serializable

data class Feedback(
    var name:String,
    var feedback_message:String,
    var device_model:String,
    var os_ver:String,
    var ip:String
):Serializable

