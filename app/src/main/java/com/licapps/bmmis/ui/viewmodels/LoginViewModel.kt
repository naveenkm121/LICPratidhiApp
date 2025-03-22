package com.licapps.bmmis.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.google.gson.Gson
import com.licapps.bmmis.data.model.login.LoginReq
import com.licapps.bmmis.data.model.login.LoginRes
import com.licapps.bmmis.data.repository.AnandaRepository
import com.licapps.bmmis.utils.DebugHandler
import com.licapps.bmmis.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: AnandaRepository
) : ViewModel() {
    private val _request = MutableLiveData<LoginReq>()

    private val _response = _request.switchMap { request ->
        repository.login(request)

    }
    val response: LiveData<Resource<LoginRes>> = _response
    fun login(request: LoginReq) {
        val req: String = Gson().toJson(request)
        DebugHandler.log("CommonReq ::  $req")
        _request.value = request

    }
}
