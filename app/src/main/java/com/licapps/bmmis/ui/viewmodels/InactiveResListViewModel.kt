package com.licapps.bmmis.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.google.gson.Gson
import com.licapps.bmmis.constants.AppConstants
import com.licapps.bmmis.constants.ScreenName
import com.licapps.bmmis.data.model.inactive.InactiveDORes
import com.licapps.bmmis.data.model.prospectives.CommonReq
import com.licapps.bmmis.data.repository.AnandaRepository
import com.licapps.bmmis.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class InactiveResListViewModel @Inject constructor(
    private val repository: AnandaRepository
) : ViewModel() {
    private val _request = MutableLiveData<CommonReq>()
    private var screenToShow: String = ""
    private var requestType: String = ""
    private val _response = _request.switchMap { request ->
        when (screenToShow) {
            ScreenName.INACTIVE_LIST_DO.value -> {

                when(requestType){

                    AppConstants.REQ_INACT_DO_FOR_DAY->repository.getInactiveDOForDayList(request)
                    AppConstants.REQ_INACT_DO_FOR_MONTH->repository.getInactiveDOForMonthList(request)
                    else -> throw AssertionError()
                }

            }
            ScreenName.INACTIVE_LIST_CLIA.value -> {

                when(requestType){

                    AppConstants.REQ_INACT_CLIA_FOR_DAY->repository.getInactiveCliaForDayList(request)
                    AppConstants.REQ_INACT_CLIA_FOR_MONTH->repository.getInactiveCliaForMonthList(request)
                    else -> throw AssertionError()
                }

            }
            //ScreenName.INACTIVE_LIST_CLIA.value -> repository.getInactiveCLIAList(request)
            else -> throw AssertionError()
        }
    }
    val response: LiveData<Resource<InactiveDORes>> = _response
    fun getInactiveResList(request: CommonReq, screenToShow: String,requestType:String) {
        val req: String = Gson().toJson(request)
        this.screenToShow = screenToShow
        this.requestType=requestType
        Timber.d("CommonReq $req" + "screenToShow "+screenToShow+" ::"+requestType)
        _request.value = request

    }

}