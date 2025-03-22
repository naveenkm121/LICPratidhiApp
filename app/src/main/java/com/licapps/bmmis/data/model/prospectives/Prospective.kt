package com.licapps.bmmis.data.model.prospectives

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "prospectives")
data class Prospective(
    var agencyName: String = "",
    @PrimaryKey
    var agencyCode: String = "",
    var qualMDRT: String = "",
    var prospMDRT: String = "",
    var nop: String = "",
    var fp: String = "",
    var srno:Int=0,
    var commission:String="",
    var qualCentury:String="",
)