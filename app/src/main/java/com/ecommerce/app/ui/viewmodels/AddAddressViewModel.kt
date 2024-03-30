package com.ecommerce.app.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.ecommerce.app.data.CommonReq
import com.ecommerce.app.data.address.AddAddressRes
import com.ecommerce.app.data.address.AddressReq
import com.ecommerce.app.data.address.PincodeRes
import com.ecommerce.app.data.wishlist.WishlistRes
import com.ecommerce.app.services.repository.UserRepository
import com.ecommerce.app.utils.DebugHandler
import com.ecommerce.app.utils.ResourceViewState
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddAddressViewModel @Inject constructor(private val userRepository: UserRepository): ViewModel() {


    private val _request = MutableLiveData<String>()

    private val _request_add_address = MutableLiveData<AddressReq>()

    private val _response = _request.switchMap { request->
        userRepository.getPincodeDetails(request)

    }
    private val _response_add_address = _request_add_address.switchMap { request->
        userRepository.addAddress(request)

    }

    val response: LiveData<ResourceViewState<PincodeRes>> = _response
    val responseAddAddress: LiveData<ResourceViewState<AddAddressRes>> = _response_add_address

    fun addAddress(request: AddressReq) {
        val req: String = Gson().toJson(request)
        DebugHandler.log("CommonReq ::  $req")
        _request_add_address.value = request

    }

    fun getPincodeDetails(request: String) {
        val req: String = Gson().toJson(request)
        DebugHandler.log("CommonReq ::  $req")
        _request.value = request

    }

}