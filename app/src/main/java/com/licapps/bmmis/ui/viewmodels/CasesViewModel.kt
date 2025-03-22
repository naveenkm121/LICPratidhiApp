package com.licapps.bmmis.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.google.gson.Gson
import com.licapps.bmmis.constants.ScreenName
import com.licapps.bmmis.data.model.prospectives.ProspectivesListRes
import com.licapps.bmmis.data.model.prospectives.CommonReq
import com.licapps.bmmis.data.repository.AnandaRepository
import com.licapps.bmmis.utils.DebugHandler
import com.licapps.bmmis.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import java.lang.AssertionError
import javax.inject.Inject

@HiltViewModel
class CasesViewModel @Inject constructor(
    private val repository: AnandaRepository

) : ViewModel() {
    private val _request = MutableLiveData<CommonReq>()
    private var screenToShow: String=""
    private val _response = _request.switchMap { request ->
        when(screenToShow){
            ScreenName.PROSPECTIVE_FP.value->repository.getProspectivesList(request)
            ScreenName.PROSPECTIVE_MDRT_COMM.value->repository.getProspMDRTCommList(request)
            ScreenName.PROSPECTIVE_CENTURION.value->repository.getProspCenturionsList(request)
            else->throw AssertionError()
        }





    }
    val response: LiveData<Resource<ProspectivesListRes>> = _response
    fun getProspectiveAgents(request: CommonReq,screenToShow:String) {
        val req: String = Gson().toJson(request)
        this.screenToShow=screenToShow
        Timber.d("CommonReq $req")
        _request.value = request

    }

}
