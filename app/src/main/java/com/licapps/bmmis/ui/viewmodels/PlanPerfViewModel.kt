package com.licapps.bmmis.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.google.gson.Gson
import com.licapps.bmmis.data.model.activisation.ActivisationListRes
import com.licapps.bmmis.data.model.boc.BOCListRes
import com.licapps.bmmis.data.model.planperf.PlanPerfRes
import com.licapps.bmmis.data.model.prospectives.CommonReq
import com.licapps.bmmis.data.model.resbuilding.ResBuildingRes
import com.licapps.bmmis.data.model.resource.ResourceListRes
import com.licapps.bmmis.data.repository.AnandaRepository
import com.licapps.bmmis.utils.DebugHandler
import com.licapps.bmmis.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class PlanPerfViewModel @Inject constructor(
    private val repository: AnandaRepository
) : ViewModel() {
    private val _request = MutableLiveData<CommonReq>()

    private val _response = _request.switchMap { request ->
        repository.getPlanPerfData(request)

    }
    val response: LiveData<Resource<PlanPerfRes>> = _response
    fun getPlanPerfData(request: CommonReq) {
        val req: String = Gson().toJson(request)
        DebugHandler.log("CommonReq ::  $req")
        _request.value = request

    }
}
