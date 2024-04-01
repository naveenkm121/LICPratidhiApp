package com.ecommerce.app.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.paging.PagingData
import com.ecommerce.app.data.address.AddressDataRes
import com.ecommerce.app.data.address.AddressReq
import com.ecommerce.app.data.address.AddressRes
import com.ecommerce.app.data.product.ProductItem
import com.ecommerce.app.data.product.ProductReqParam
import com.ecommerce.app.data.wishlist.WishlistRes
import com.ecommerce.app.services.repository.ProductRespository
import com.ecommerce.app.services.repository.UserRepository
import com.ecommerce.app.utils.DebugHandler
import com.ecommerce.app.utils.ResourceViewState
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddressViewModel @Inject constructor(private val userRepository: UserRepository):
    ViewModel() {


    private val _request = MutableLiveData<String>()
    private val _request_delete_address = MutableLiveData<Int>()

    private val _response = _request.switchMap { request->
        userRepository.getAddressList()

    }

    private val _response_delete_address = _request_delete_address.switchMap { request->
        userRepository.deleteAddress(request)

    }

    val response: LiveData<ResourceViewState<AddressRes>> = _response
    val responseDeleteAddress: LiveData<ResourceViewState<AddressDataRes>> = _response_delete_address

    fun getAddress(request: String?) {
        DebugHandler.log("CommonReq ::  $request")
        _request.value = request!!

    }
    fun deleteAddress(request: Int?) {
        DebugHandler.log("CommonReq ::  $request")
        _request_delete_address.value = request!!

    }

}