package com.ecommerce.app.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ecommerce.app.data.CommonReq
import com.ecommerce.app.data.PokemonRes
import androidx.lifecycle.switchMap
import com.ecommerce.app.services.repository.ProductRespository
import com.ecommerce.app.utils.DebugHandler
import com.ecommerce.app.utils.ResourceViewState
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val productRespository: ProductRespository):ViewModel() {


    private val _request = MutableLiveData<CommonReq>()

    private val _response = _request.switchMap {
        productRespository.getPokemons()

    }
    val response: LiveData<ResourceViewState<PokemonRes>> = _response

    fun getPokemonData(request: CommonReq) {
        val req: String = Gson().toJson(request)
        DebugHandler.log("CommonReq ::  $req")
        _request.value = request

    }
}