package com.licapps.bmmis.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.licapps.bmmis.data.model.util.LaunchRes
import com.licapps.bmmis.data.repository.AnandaRepository
import com.licapps.bmmis.data.repository.PlansRepository
import com.licapps.bmmis.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SplashViewModel @Inject constructor(
    private val repository: AnandaRepository
) : ViewModel() {


    private val _request = MutableLiveData<String>()

    private val _response = _request.switchMap { request ->
        repository.getLaunchStatus()

    }
    val response: LiveData<Resource<LaunchRes>> = _response
    fun getLaunchStatus(request: String) {
        _request.value = request

    }
}
