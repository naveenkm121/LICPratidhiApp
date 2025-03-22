package com.licapps.bmmis.data.api

import com.licapps.bmmis.data.model.emhr.EmhrReq
import com.licapps.bmmis.data.model.login.LoginReq
import com.licapps.bmmis.data.model.mab.MABReq
import com.licapps.bmmis.data.model.nua.NuaReq
import com.licapps.bmmis.data.model.prospectives.CommonReq
import javax.inject.Inject

class BMMisRemoteDataSource @Inject constructor(
    private val anandaServices: AnandaServices
) : BaseDataSource() {
    suspend fun login(loginRequest: LoginReq) = getResult { anandaServices.login(loginRequest) }

    suspend fun getAllWishes(request: CommonReq) =
        getResult { anandaServices.getAllWishes(request) }

    suspend fun getProspectivesList(request: CommonReq) =
        getResult { anandaServices.getProspectivesList(request) }

    suspend fun getProspMDRTCommList(request: CommonReq) =
        getResult { anandaServices.getProspMDRTCommList(request) }

    suspend fun getProspCenturionsList(request: CommonReq) =
        getResult { anandaServices.getProspCenturionsList(request) }

    suspend fun getTopDevByNOP(request: CommonReq) =
        getResult { anandaServices.getTopDevByNOP(request) }

    suspend fun getTopDevByFP(request: CommonReq) =
        getResult { anandaServices.getTopDevByFP(request) }

    suspend fun getTopAgentsByNOP(request: CommonReq) =
        getResult { anandaServices.getTopAgentsByNOP(request) }

    suspend fun getTopAgentsByFP(request: CommonReq) =
        getResult { anandaServices.getTopAgentsByFP(request) }

    suspend fun getTopCLIAsByNOP(request: CommonReq) =
        getResult { anandaServices.getTopCLIAsByNOP(request) }

    suspend fun getTopCLIAsByFP(request: CommonReq) =
        getResult { anandaServices.getTopCLIAsByFP(request) }

    suspend fun getNBperformanceByV(request: CommonReq) =
        getResult { anandaServices.getNBperformanceByV(request) }

    suspend fun getNBperformanceByG(request: CommonReq) =
        getResult { anandaServices.getNBperformanceByG(request) }

    suspend fun getNBperformanceByA2B(request: CommonReq) =
        getResult { anandaServices.getNBperformanceByA2B(request) }

    suspend fun getNBperformanceMonthByG(request: CommonReq) =
        getResult { anandaServices.getNBperformanceMonthByG(request) }

    suspend fun getNBperformanceMonthByV(request: CommonReq) =
        getResult { anandaServices.getNBperformanceMonthByV(request) }

    suspend fun getNBperformanceMonthByA2B(request: CommonReq) =
        getResult { anandaServices.getNBperformanceMonthByA2B(request) }

    suspend fun getAvailableResource(request: CommonReq) =
        getResult { anandaServices.getAvailableResource(request) }

    suspend fun getBOCdata(request: CommonReq) =
        getResult { anandaServices.getBOCdata(request) }

    suspend fun getChannelWiseNB(request: CommonReq) =
        getResult { anandaServices.getChannelWiseNB(request) }

    suspend fun getNBForDay(request: CommonReq) =
        getResult { anandaServices.getNBForDay(request) }

    suspend fun getResBuildingData(request: CommonReq) =
        getResult { anandaServices.getResBuildingData(request) }

    suspend fun getAnandaData(request: CommonReq) =
        getResult { anandaServices.getAnandaData(request) }

    suspend fun getMABData(request: MABReq) =
        getResult { anandaServices.getMABData(request) }

    suspend fun getActivisationData(request: CommonReq) =
        getResult { anandaServices.getActivisationData(request) }

    suspend fun getInactiveResources(request: CommonReq) =
        getResult { anandaServices.getInactiveResources(request) }

    suspend fun getInactiveDOForDayList(request: CommonReq) =
        getResult { anandaServices.getInactiveDOForDayList(request) }

    suspend fun getInactiveDOForMonthList(request: CommonReq) =
            getResult { anandaServices.getInactiveDOForMonthList(request) }

    suspend fun getInactiveCliaForDayList(request: CommonReq) =
            getResult { anandaServices.getInactiveCliaForDayList(request) }

    suspend fun getInactiveCliaForMonthList(request: CommonReq) =
            getResult { anandaServices.getInactiveCliaForMonthList(request) }


    suspend fun getInactiveCLIAList(request: CommonReq) =
        getResult { anandaServices.getInactiveCLIAList(request) }

    suspend fun getClaimsData(request: CommonReq) =
        getResult { anandaServices.getClaimsData(request) }

    suspend fun getPlanPerfData(request: CommonReq) =
        getResult { anandaServices.getPlanPerfData(request) }

    suspend fun getLaunchStatus() = getResult { anandaServices.getLaunchStatus() }

    suspend fun getPersistenceData(request: CommonReq) =
        getResult { anandaServices.getPersistenceData(request) }

    suspend fun getPersistenceOnPremData(request: CommonReq) =
        getResult { anandaServices.getPersistenceOnPremData(request) }

    suspend fun getNuaData(request: NuaReq) =
        getResult { anandaServices.getNuaData(request) }

    suspend fun getEMHRData(request: EmhrReq) =
        getResult { anandaServices.getEMHRData(request) }

}