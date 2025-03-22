package com.licapps.bmmis.data.repository


import com.licapps.bmmis.data.api.PlanRemoteDataSource
import com.licapps.bmmis.data.localdb.PlanDao
import com.licapps.bmmis.data.model.*
import com.licapps.bmmis.utils.performGetOperation
import javax.inject.Inject

class PlansRepository @Inject constructor(
    private val remoteDataSource: PlanRemoteDataSource,
    private val localDataSource: PlanDao,
) {

   /* fun getPlan(id: Int) = performGetOperation(
        databaseQuery = { localDataSource.getPlan(id) },
        networkCall = { remoteDataSource.getPlan(id) },
        saveCallResult = { localDataSource.insertPlan(it) }
    )

    fun getPlans() = performGetOperation(
        databaseQuery = { localDataSource.getAllPlans() },
        networkCall = { remoteDataSource.getPlans() },
        clearTable = { localDataSource.deleteAllPlans() },
        saveCallResult = { localDataSource.insertAllPlans(it.results) }
    )
    fun calculatePremium(planPremInfo: PlanPremInfo) = performGetOperation(
        networkCall = { remoteDataSource.calculatePremium(planPremInfo) }
    )
    fun sendFeedback(feedback: Feedback) = performGetOperation(
        networkCall = { remoteDataSource.sendFeedback(feedback) }
    )
*/
    fun downloadFile(url: String) = performGetOperation(
        networkCall = { remoteDataSource.downloadFile(url) }
    )



}