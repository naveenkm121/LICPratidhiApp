package com.licapps.bmmis.data.model.persistence

data class PersistenceRes(
    var message: String = "",
    var status: Int = 0,
    var data: List<PersistenceData> = listOf()
)