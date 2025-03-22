package com.licapps.bmmis.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.google.gson.Gson
import com.licapps.bmmis.data.model.nua.NuaReq
import com.licapps.bmmis.data.model.nua.NuaRes
import com.licapps.bmmis.data.model.persistence.PersistenceRes
import com.licapps.bmmis.data.model.prospectives.CommonReq
import com.licapps.bmmis.data.repository.AnandaRepository
import com.licapps.bmmis.utils.DebugHandler
import com.licapps.bmmis.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NUAViewmodel @Inject constructor(
    private val repository: AnandaRepository
) : ViewModel() {
    private val _request = MutableLiveData<NuaReq>()

    private val _response = _request.switchMap { request ->
        repository.getNuaData(request)

    }
    val response: LiveData<Resource<NuaRes>> = _response

    fun getNuaData(request: NuaReq) {
        val req: String = Gson().toJson(request)
        DebugHandler.log("NuaReq ::  $req")
        _request.value = request

    }
}
