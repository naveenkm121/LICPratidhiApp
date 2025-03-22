package com.licapps.bmmis.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.google.gson.Gson
import com.licapps.bmmis.data.model.prospectives.CommonReq
import com.licapps.bmmis.data.model.topperformers.PerformersListRes
import com.licapps.bmmis.data.repository.AnandaRepository
import com.licapps.bmmis.utils.DebugHandler
import com.licapps.bmmis.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class TopPerformersViewModel @Inject constructor(
    private val repository: AnandaRepository
) : ViewModel() {
    private val _request = MutableLiveData<CommonReq>()
    private var _whichrequest = 0

    private val _response = _request.switchMap { request ->

        when (_whichrequest) {
            0 -> repository.getTopDevByNOP(request)
            1 -> repository.getTopDevByFP(request)
            2 -> repository.getTopAgentsByNOP(request)
            3 -> repository.getTopAgentsByFP(request)
            4 -> repository.getTopCLIAsByNOP(request)
            5 -> repository.getTopCLIAsByFP(request)
            else -> throw AssertionError()
        }


    }

    val responseNOP: LiveData<Resource<PerformersListRes>> = _response

    fun getTopPerformers(request: CommonReq, whichRequest: Int) {
        val req: String = Gson().toJson(request)
        DebugHandler.log("CommonReq $req")
        Timber.d(whichRequest.toString())
        _whichrequest = whichRequest
        _request.value = request

    }


}
