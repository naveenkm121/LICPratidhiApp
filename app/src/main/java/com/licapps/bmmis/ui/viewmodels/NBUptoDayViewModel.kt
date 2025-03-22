package com.licapps.bmmis.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.google.gson.Gson
import com.licapps.bmmis.data.model.nbperformance.NBPerformanceRes
import com.licapps.bmmis.data.model.prospectives.CommonReq
import com.licapps.bmmis.data.model.topperformers.PerformersListRes
import com.licapps.bmmis.data.repository.AnandaRepository
import com.licapps.bmmis.utils.DebugHandler
import com.licapps.bmmis.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NBUptoDayViewModel @Inject constructor(
    private val repository: AnandaRepository
) : ViewModel() {
    private val _request = MutableLiveData<CommonReq>()
    private var _whichrequest = 0

    private val _response = _request.switchMap { request ->

        when (_whichrequest) {
            0 -> repository.getNBperformanceByG(request)
            1 -> repository.getNBperformanceByV(request)
            2 -> repository.getNBperformanceByA2B(request)
            else -> throw AssertionError()
        }

    }

    val response: LiveData<Resource<NBPerformanceRes>> = _response

    fun getNBUptoDay(request: CommonReq, whichRequest: Int) {
        val req: String = Gson().toJson(request)
        DebugHandler.log("CommonReq $req")
        _whichrequest = whichRequest
        _request.value = request

    }


}
