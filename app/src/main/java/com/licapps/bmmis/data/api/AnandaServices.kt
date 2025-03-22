package com.licapps.bmmis.data.api


import com.licapps.bmmis.data.model.WishesRes
import com.licapps.bmmis.data.model.activisation.ActivisationListRes
import com.licapps.bmmis.data.model.ananda.AnandaRes
import com.licapps.bmmis.data.model.boc.BOCListRes
import com.licapps.bmmis.data.model.channelwise.ChannelwiseNBRes
import com.licapps.bmmis.data.model.claims.ClaimsRes
import com.licapps.bmmis.data.model.emhr.EmhrReq
import com.licapps.bmmis.data.model.emhr.EmhrRes
import com.licapps.bmmis.data.model.inactive.InactiveDORes
import com.licapps.bmmis.data.model.inactive.InactiveRes
import com.licapps.bmmis.data.model.login.LoginReq
import com.licapps.bmmis.data.model.login.LoginRes
import com.licapps.bmmis.data.model.mab.MABListRes
import com.licapps.bmmis.data.model.mab.MABReq
import com.licapps.bmmis.data.model.nbforday.NBForDayRes
import com.licapps.bmmis.data.model.nbperformance.NBPerformanceRes
import com.licapps.bmmis.data.model.nua.NuaReq
import com.licapps.bmmis.data.model.nua.NuaRes
import com.licapps.bmmis.data.model.persistence.PersistenceRes
import com.licapps.bmmis.data.model.planperf.PlanPerfRes
import com.licapps.bmmis.data.model.prospectives.CommonReq
import com.licapps.bmmis.data.model.prospectives.ProspectivesListRes
import com.licapps.bmmis.data.model.resbuilding.ResBuildingRes
import com.licapps.bmmis.data.model.resource.ResourceListRes
import com.licapps.bmmis.data.model.topperformers.PerformersListRes
import com.licapps.bmmis.data.model.util.LaunchRes
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AnandaServices {

    @POST("newLogin")
    suspend fun login(@Body loginRequest: LoginReq): Response<LoginRes>

    @POST("wishes")
    suspend fun getAllWishes(@Body request: CommonReq) : Response<WishesRes>

    @GET("launch")
    suspend fun getLaunchStatus(): Response<LaunchRes>
    @POST("MDRT")
    suspend fun getProspectivesList(@Body request: CommonReq): Response<ProspectivesListRes>
    @POST("MDRTComm")
    suspend fun getProspMDRTCommList(@Body request: CommonReq): Response<ProspectivesListRes>
    @POST("Centurion")
    suspend fun getProspCenturionsList(@Body request: CommonReq): Response<ProspectivesListRes>

    @POST("TopPerfDevPol")
    suspend fun getTopDevByNOP(@Body request: CommonReq): Response<PerformersListRes>

    @POST("TopPerfDevFp")
    suspend fun getTopDevByFP(@Body request: CommonReq): Response<PerformersListRes>

    @POST("TopPerfAgPol")
    suspend fun getTopAgentsByNOP(@Body request: CommonReq): Response<PerformersListRes>

    @POST("TopPerfAgFp")
    suspend fun getTopAgentsByFP(@Body request: CommonReq): Response<PerformersListRes>

    @POST("TopPerfCLIPol")
    suspend fun getTopCLIAsByNOP(@Body request: CommonReq): Response<PerformersListRes>

    @POST("TopPerfCLIFp")
    suspend fun getTopCLIAsByFP(@Body request: CommonReq): Response<PerformersListRes>

    @POST("NBPerfUptoV")
    suspend fun getNBperformanceByV(@Body request: CommonReq): Response<NBPerformanceRes>

    @POST("NBPerfUptoG")
    suspend fun getNBperformanceByG(@Body request: CommonReq): Response<NBPerformanceRes>

    @POST("NBPerfUptoA2B")
    suspend fun getNBperformanceByA2B(@Body request: CommonReq): Response<NBPerformanceRes>

    @POST("NBPerfMonthG")
    suspend fun getNBperformanceMonthByG(@Body request: CommonReq): Response<NBPerformanceRes>

    @POST("NBPerfMonth")
    suspend fun getNBperformanceMonthByV(@Body request: CommonReq): Response<NBPerformanceRes>

    @POST("NBPerfMonthA2B")
    suspend fun getNBperformanceMonthByA2B(@Body request: CommonReq): Response<NBPerformanceRes>

    @POST("Res")
    suspend fun getAvailableResource(@Body request: CommonReq): Response<ResourceListRes>

    @POST("BOC")
    suspend fun getBOCdata(@Body request: CommonReq): Response<BOCListRes>

    @POST("ChannelWise")
    suspend fun getChannelWiseNB(@Body request: CommonReq): Response<ChannelwiseNBRes>

    @POST("NBForDay")
    suspend fun getNBForDay(@Body request: CommonReq): Response<NBForDayRes>

    @POST("ResBuild")
    suspend fun getResBuildingData(@Body request: CommonReq): Response<ResBuildingRes>

    @POST("Ananda")
    suspend fun getAnandaData(@Body request: CommonReq): Response<AnandaRes>

    @POST("MAB")
    suspend fun getMABData(@Body request: MABReq): Response<MABListRes>

    @POST("Activisation")
    suspend fun getActivisationData(@Body request: CommonReq): Response<ActivisationListRes>

    @POST("Inactive")
    suspend fun getInactiveResources(@Body request: CommonReq): Response<InactiveRes>

    @POST("InactDevDay")
    suspend fun getInactiveDOForDayList(@Body request: CommonReq): Response<InactiveDORes>

    @POST("InactDevMonth")
    suspend fun getInactiveDOForMonthList(@Body request: CommonReq): Response<InactiveDORes>

    @POST("InactCliaDay")
    suspend fun getInactiveCliaForDayList(@Body request: CommonReq): Response<InactiveDORes>

    @POST("InactCliaMonth")
    suspend fun getInactiveCliaForMonthList(@Body request: CommonReq): Response<InactiveDORes>


    @POST("Inactagclia")
    suspend fun getInactiveCLIAList(@Body request: CommonReq): Response<InactiveDORes>

    @POST("Claims")
    suspend fun getClaimsData(@Body request: CommonReq): Response<ClaimsRes>

    @POST("Planwise")
    suspend fun getPlanPerfData(@Body request: CommonReq): Response<PlanPerfRes>

    @POST("Persist")
    suspend fun getPersistenceData(@Body request: CommonReq): Response<PersistenceRes>

    @POST("PersistPrem")
    suspend fun getPersistenceOnPremData(@Body request: CommonReq): Response<PersistenceRes>

    @POST("getRatingSheetDetails")
    suspend fun getNuaData(@Body request: NuaReq): Response<NuaRes>

    @POST("getEMHRPendingList")
    suspend fun getEMHRData(@Body request: EmhrReq): Response<EmhrRes>



}