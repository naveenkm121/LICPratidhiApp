package com.licapps.bmmis.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.google.gson.Gson
import com.licapps.bmmis.data.model.inactive.InactiveRes
import com.licapps.bmmis.data.model.persistence.PersistenceRes
import com.licapps.bmmis.data.model.prospectives.CommonReq
import com.licapps.bmmis.data.repository.AnandaRepository
import com.licapps.bmmis.utils.DebugHandler
import com.licapps.bmmis.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PersistenceViewModel @Inject constructor(
    private val repository: AnandaRepository
) : ViewModel() {
    private val _request = MutableLiveData<CommonReq>()
    private var _whichrequest = 0
    private val _response = _request.switchMap { request ->
        repository.getPersistenceData(request)
        when (_whichrequest) {
            0 -> repository.getPersistenceData(request)
            1 -> repository.getPersistenceOnPremData(request)
            else -> throw AssertionError()
        }
    }
    val response: LiveData<Resource<PersistenceRes>> = _response
    fun getPersistenceData(request: CommonReq, whichRequest: Int) {
        val req: String = Gson().toJson(request)
        DebugHandler.log("CommonReq ::  $req")
        _whichrequest = whichRequest
        _request.value = request

    }
}
