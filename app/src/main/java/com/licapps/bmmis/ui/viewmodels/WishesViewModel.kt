package com.licapps.bmmis.ui.viewmodels

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.google.gson.Gson
import com.licapps.bmmis.data.model.WishesRes
import com.licapps.bmmis.data.model.activisation.ActivisationListRes
import com.licapps.bmmis.data.model.prospectives.CommonReq
import com.licapps.bmmis.data.repository.AnandaRepository
import com.licapps.bmmis.utils.DebugHandler
import com.licapps.bmmis.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WishesViewModel @Inject constructor(
    private val repository: AnandaRepository
) : ViewModel() {

        private val _request = MutableLiveData<CommonReq>()

        private val _response = _request.switchMap { request ->
            repository.getWishes(request)

        }
        val response: LiveData<Resource<WishesRes>> = _response
        fun getWishesList(request: CommonReq) {
            val req: String = Gson().toJson(request)
            DebugHandler.log("CommonReq ::  $req")
            _request.value = request

        }

}
