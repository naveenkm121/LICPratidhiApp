package com.licapps.bmmis.data.repository


import com.licapps.bmmis.data.api.BMMisRemoteDataSource
import com.licapps.bmmis.data.localdb.PlanDao
import com.licapps.bmmis.data.model.emhr.EmhrReq
import com.licapps.bmmis.data.model.emhr.EmhrRes
import com.licapps.bmmis.data.model.login.LoginReq
import com.licapps.bmmis.data.model.mab.MABReq
import com.licapps.bmmis.data.model.nua.NuaReq
import com.licapps.bmmis.data.model.prospectives.CommonReq
import com.licapps.bmmis.utils.performGetOperation
import javax.inject.Inject

class AnandaRepository @Inject constructor(
    private val remoteDataSource: BMMisRemoteDataSource,
    private val localDataSource: PlanDao,
) {

    fun login(loginRequest: LoginReq) = performGetOperation(
        networkCall = { remoteDataSource.login(loginRequest) }
    )

    fun getWishes( request: CommonReq) = performGetOperation(
        networkCall = { remoteDataSource.getAllWishes(request) },
    )
    fun getLaunchStatus() = performGetOperation(
        networkCall = { remoteDataSource.getLaunchStatus() }
    )

    fun getProspectivesList(request: CommonReq) = performGetOperation(
        networkCall = { remoteDataSource.getProspectivesList(request) }
    )
    fun getProspMDRTCommList(request: CommonReq) = performGetOperation(
        networkCall = { remoteDataSource.getProspMDRTCommList(request) }
    )
    fun getProspCenturionsList(request: CommonReq) = performGetOperation(
        networkCall = { remoteDataSource.getProspCenturionsList(request) }
    )
  /*  fun getProspectivesList(request: CommonReq) = performGetOperation(
       databaseQuery = { localDataSource.getProspectivesList() },
       networkCall = { remoteDataSource.getProspectivesList(request) },
       clearTable = { localDataSource.deleteAllProspectives() },
       saveCallResult = { localDataSource.insertAllProspectives(it.data) }
    )*/

    fun getTopDevByNOP(request: CommonReq) = performGetOperation(
        networkCall = { remoteDataSource.getTopDevByNOP(request) }
    )

    fun getTopDevByFP(request: CommonReq) = performGetOperation(
        networkCall = { remoteDataSource.getTopDevByFP(request) }
    )

    fun getTopAgentsByNOP(request: CommonReq) = performGetOperation(
        networkCall = { remoteDataSource.getTopAgentsByNOP(request) }
    )

    fun getTopAgentsByFP(request: CommonReq) = performGetOperation(
        networkCall = { remoteDataSource.getTopAgentsByFP(request) }
    )

    fun getTopCLIAsByNOP(request: CommonReq) = performGetOperation(
        networkCall = { remoteDataSource.getTopCLIAsByNOP(request) }
    )

    fun getTopCLIAsByFP(request: CommonReq) = performGetOperation(
        networkCall = { remoteDataSource.getTopCLIAsByFP(request) }
    )
    fun getNBperformanceByV(request: CommonReq) = performGetOperation(
        networkCall = { remoteDataSource.getNBperformanceByV(request) }
    )
    fun getNBperformanceByG(request: CommonReq) = performGetOperation(
        networkCall = { remoteDataSource.getNBperformanceByG(request) }
    )
    fun getNBperformanceByA2B(request: CommonReq) = performGetOperation(
        networkCall = { remoteDataSource.getNBperformanceByA2B(request) }
    )

    fun getNBperformanceMonthByG(request: CommonReq) = performGetOperation(
        networkCall = { remoteDataSource.getNBperformanceMonthByG(request) }
    )

    fun getNBperformanceMonthByV(request: CommonReq) = performGetOperation(
        networkCall = { remoteDataSource.getNBperformanceMonthByV(request) }
    )
    fun getNBperformanceMonthByA2B(request: CommonReq) = performGetOperation(
        networkCall = { remoteDataSource.getNBperformanceMonthByA2B(request) }
    )

    fun getAvailableResource(request: CommonReq) = performGetOperation(
        networkCall = { remoteDataSource.getAvailableResource(request) }
    )
    fun getBOCdata(request: CommonReq) = performGetOperation(
        networkCall = { remoteDataSource.getBOCdata(request) }
    )
    fun getChannelWiseNB(request: CommonReq) = performGetOperation(
        networkCall = { remoteDataSource.getChannelWiseNB(request) }
    )

    fun getNBForDay(request: CommonReq) = performGetOperation(
        networkCall = { remoteDataSource.getNBForDay(request) }
    )

    fun getResBuildingData(request: CommonReq) = performGetOperation(
        networkCall = { remoteDataSource.getResBuildingData(request) }
    )

    fun getAnandaData(request: CommonReq) = performGetOperation(
        networkCall = { remoteDataSource.getAnandaData(request) }
    )

    fun getMABData(request: MABReq) = performGetOperation(
        networkCall = { remoteDataSource.getMABData(request) }
    )

    fun getActivisationData(request: CommonReq) = performGetOperation(
        networkCall = { remoteDataSource.getActivisationData(request) }
    )
    fun getInactiveResources(request: CommonReq) = performGetOperation(
        networkCall = { remoteDataSource.getInactiveResources(request) }
    )
    fun getInactiveDOForDayList(request: CommonReq) = performGetOperation(
        networkCall = { remoteDataSource.getInactiveDOForDayList(request) }
    )
    fun getInactiveDOForMonthList(request: CommonReq) = performGetOperation(
            networkCall = { remoteDataSource.getInactiveDOForMonthList(request) }
    )
    fun getInactiveCliaForDayList(request: CommonReq) = performGetOperation(
            networkCall = { remoteDataSource.getInactiveCliaForDayList(request) }
    )
    fun getInactiveCliaForMonthList(request: CommonReq) = performGetOperation(
            networkCall = { remoteDataSource.getInactiveCliaForMonthList(request) }
    )
    fun getInactiveCLIAList(request: CommonReq) = performGetOperation(
        networkCall = { remoteDataSource.getInactiveCLIAList(request) }
    )

    fun getClaimsData(request: CommonReq) = performGetOperation(
        networkCall = { remoteDataSource.getClaimsData(request) }
    )
    fun getPlanPerfData(request: CommonReq) = performGetOperation(
        networkCall = { remoteDataSource.getPlanPerfData(request) }
    )

    fun getPersistenceData(request: CommonReq) = performGetOperation(
        networkCall = { remoteDataSource.getPersistenceData(request) }
    )
    fun getPersistenceOnPremData(request: CommonReq) = performGetOperation(
        networkCall = { remoteDataSource.getPersistenceOnPremData(request) }
    )

    fun getNuaData(request: NuaReq) = performGetOperation(
        networkCall = { remoteDataSource.getNuaData(request) }
    )

    fun getEMHRData(request: EmhrReq) = performGetOperation(
        networkCall = { remoteDataSource.getEMHRData(request) }
    )


}