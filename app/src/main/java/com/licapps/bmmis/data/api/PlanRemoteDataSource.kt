package com.licapps.bmmis.data.api

import com.licapps.bmmis.data.model.*
import javax.inject.Inject

class PlanRemoteDataSource @Inject constructor(
    private val planServices: PlanServices
): BaseDataSource() {

    suspend fun downloadFile(url:String) = getResult { planServices.downloadFile(url) }


}