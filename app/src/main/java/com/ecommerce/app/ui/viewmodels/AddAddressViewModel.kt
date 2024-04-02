package com.ecommerce.app.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.ecommerce.app.constants.ScreenName
import com.ecommerce.app.data.address.AddressDataRes
import com.ecommerce.app.data.address.AddressReq
import com.ecommerce.app.data.address.PincodeRes
import com.ecommerce.app.services.repository.UserRepository
import com.ecommerce.app.utils.DebugHandler
import com.ecommerce.app.utils.ResourceViewState
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddAddressViewModel @Inject constructor(private val userRepository: UserRepository): ViewModel() {

    private var addressId:Int=0
    private var requestType: String = ""
    private val _request = MutableLiveData<String>()
    private val _request_address = MutableLiveData<AddressReq>()

    private val _response = _request.switchMap { request->
        userRepository.getPincodeDetails(request)

    }
    private val _response_data_address = _request_address.switchMap { request->

        when(requestType){

            ScreenName.REQUEST_ADD_ADDRESS.value->{
                userRepository.addAddress(request)
            }
            ScreenName.REQUEST_UPDATE_ADDRESS.value->{
                userRepository.updateAddress(addressId,request)
            }

            else -> throw AssertionError()
        }

    }

    val response: LiveData<ResourceViewState<PincodeRes>> = _response
    val responseAddress: LiveData<ResourceViewState<AddressDataRes>> = _response_data_address

    fun addAddress(request: AddressReq,requestType:String) {
        val req: String = Gson().toJson(request)
        DebugHandler.log("CommonReq ::  $req")
        this.requestType=requestType
        _request_address.value = request
    }

    fun updateAddress(request: AddressReq,requestType:String,addressId:Int) {
        val req: String = Gson().toJson(request)
        DebugHandler.log("CommonReq ::  $req")
        DebugHandler.log("requestType ::  $requestType")
        this.requestType=requestType
        this.addressId =addressId
        _request_address.value = request
    }

    fun getPincodeDetails(request: String) {
        val req: String = Gson().toJson(request)
        DebugHandler.log("CommonReq ::  $req")
        _request.value = request
    }

}