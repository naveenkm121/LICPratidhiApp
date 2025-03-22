package com.licapps.bmmis.data.api


import com.licapps.bmmis.data.model.*
import com.licapps.bmmis.data.model.util.LaunchRes
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface PlanServices {

    @Streaming
    @GET
    suspend fun downloadFile(@Url url:String) : Response<ResponseBody>


}